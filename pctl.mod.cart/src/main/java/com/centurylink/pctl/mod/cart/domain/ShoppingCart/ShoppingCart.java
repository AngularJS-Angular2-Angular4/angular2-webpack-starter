package com.centurylink.pctl.mod.cart.domain.ShoppingCart;
import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.model.product.Price;
import com.centurylink.pctl.mod.core.model.product.Product;
import com.centurylink.pctl.mod.core.model.product.ProductVariants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;
import reactor.core.publisher.Flux;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * The {@link ShoppingCart} object represents an aggregate of {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.CartEvent} that
 * represent actions taken by a user to add/remove/clear/checkout products from their
 * shopping cart
 *
 */
/**
 * Created by nagavenkatakirang on 21-10-2016.
 */
public class ShoppingCart {

    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    private Logger log = Logger.getLogger(ShoppingCart.class);
    private Map<String, Integer> productMap = new HashMap<>();

    @JsonIgnore
    private Map<String, AddressLocation> locationMap = new HashMap<String, AddressLocation>();


    private List<LineItem> lineItems = new ArrayList<>();

    public List<AddressLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<AddressLocation> locations) {
        this.locations = locations;
    }


    public Map<String, AddressLocation> getLocationMap() {
        return locationMap;
    }

    public void setLocationMap(Map<String, AddressLocation> locationMap) {
        this.locationMap = locationMap;
    }

    private List<AddressLocation> locations = new ArrayList<AddressLocation>();

    private Catalog catalog;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
    }

    public ShoppingCart() {
        this.catalog = new Catalog();
    }

    @JsonIgnore
    public Map<String, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Integer> productMap) {
        this.productMap = productMap;
    }

    @JsonIgnore
    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    public void initiateCatalog(CartEvent cartEvent){

        if(cartEvent.getCartEventType().equals(CartEventType.ADD_ITEM)){
            if(catalog == null )
            {
                this.catalog = new Catalog();
            }
            LineItem lineItem = new LineItem();
            lineItem.setProductId(cartEvent.getProductId());
            lineItem.setProductName(cartEvent.getProductName());
            lineItem.setProductTemplateName(cartEvent.getProductTemplateName());
            lineItem.setProductTemplateId(cartEvent.getProductTemplateId());
            lineItem.setUnitPrice(cartEvent.getUnitPrice());
            lineItem.setQuantity(cartEvent.getQuantity());
            lineItem.set_id(cartEvent.getId());
            Set<LineItem> products = new HashSet<LineItem>();
            products.add(lineItem);
            this.catalog.setProducts(products);
        }
    }

    /**
     * Get the line items from the aggregate of add cart events
     *
     * @return a new list of {@link LineItem} representing the state of the shopping cart
     * @throws Exception if a product in the cart could not be found in the catalog
     */
    public List<LineItem> getLineItems() throws Exception {





        lineItems = productMap.entrySet()
            .stream()
            .map(item -> new LineItem(

                catalog.getProducts().stream()
                .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                .findFirst().get().get_id(),
                item.getKey(),
                item.getValue(),
                catalog.getProducts().stream()
                    .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                    .findFirst().get().getProductName(),
                catalog.getProducts().stream()
                    .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                    .findFirst().get().getProductTemplateName(),
                catalog.getProducts().stream()
                    .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                    .findFirst().get().getProductTemplateId(),
                catalog.getProducts().stream()
                    .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                    .findFirst().get().getUnitPrice(),
                locationMap.entrySet()
                    .stream()
                    .filter(address -> Objects.equals(address.getKey(), item.getKey() + address.getValue().getId()))
                    .filter(addressLocation -> addressLocation.getValue().getLocationCount() > 0)
                    .map(addressEntry -> addressEntry.getValue())
                    .collect(Collectors.toList())
            ))
            .filter(item -> item.getQuantity() > 0)
            .collect(Collectors.toList()).stream()
            .map(lineItem ->
                new LineItem(
                    lineItem.get_id(),
                    lineItem.getProductId(),
                    (lineItem.getLocations().size()>lineItem.getQuantity())?lineItem.getLocations().size() :  lineItem.getQuantity(),
                    lineItem.getProductName(),
                    lineItem.getProductTemplateName(),
                    lineItem.getProductTemplateId(),
                    lineItem.getUnitPrice(),
                    lineItem.getLocations()))
            .collect(Collectors.toList());

       /* if (lineItems.stream()
            .anyMatch(item -> item.getProduct() == null)) {
            throw new Exception("Product not found in catalog");
        }*/






        return lineItems;
    }


    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Incorporates a new {@link CartEvent} and updated the shopping cart
     *
     * @param cartEvent is the {@link CartEvent} that will alter the state of the cart
     * @return the state of the {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.ShoppingCart} after applying the new {@link CartEvent}
     */
    public ShoppingCart incorporate(CartEvent cartEvent) {
        // Safety properties in microservices
        Flux<CartEventType> validCartEventTypes =
                Flux.fromStream(Stream.of(CartEventType.ADD_ITEM,
                        CartEventType.REMOVE_ITEM));

        // The CartEvent's type must be either ADD_ITEM or REMOVE_ITEM
        if (validCartEventTypes.exists(cartEventType ->
                cartEvent.getCartEventType().equals(cartEventType)).get()) {
            // Update the aggregate view of each line item's quantity from the event type
            productMap.put(cartEvent.getProductId(),
                    productMap.getOrDefault(cartEvent.getProductId(), 0) +
                            (cartEvent.getQuantity() * (cartEvent.getCartEventType()
                                    .equals(CartEventType.ADD_ITEM) ? 1 : -1)));
        }

        // Return the updated state of the aggregate to the reactive stream's reduce method
        return this;
    }





    /**
     * Incorporates a new {@link CartEvent} and updated the shopping cart
     *
     * @param cartEvent is the {@link CartEvent} that will alter the state of the cart
     * @return the state of the {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.ShoppingCart} after applying the new {@link CartEvent}
     */
    public ShoppingCart incorporateWithLocation(CartEvent cartEvent) {
        // Safety properties in microservices
        Flux<CartEventType> validCartLineItemEventTypes =
            Flux.fromStream(Stream.of(CartEventType.ADD_ITEM,
                CartEventType.REMOVE_ITEM));

        Flux<CartEventType> validCartLocationEventTypes =
            Flux.fromStream(Stream.of(CartEventType.ADD_LOCATION,
                CartEventType.UPDATE_LOCATION,CartEventType.REMOVE_LOCATION));

        // The CartEvent's type must be either ADD_ITEM or REMOVE_ITEM
        if (validCartLineItemEventTypes.exists(cartEventType ->
            cartEvent.getCartEventType().equals(cartEventType)).get()) {

                initiateCatalog(cartEvent);
                productMap.put(cartEvent.getProductId(),
                    productMap.getOrDefault(cartEvent.getProductId(), 0) +
                        (cartEvent.getQuantity() * (cartEvent.getCartEventType()
                            .equals(CartEventType.ADD_ITEM) ? 1 : -1)));

        }


        if (validCartLocationEventTypes.exists(cartEventType ->
            cartEvent.getCartEventType().equals(cartEventType)).get()) {
            // Update the aggregate view of each line item's quantity from the event type
            AddressLocation addressLocation = new AddressLocation();
            addressLocation.setId(cartEvent.getLocation().getId());
            addressLocation.setServiceAddress(cartEvent.getLocation().getServiceAddress());
            addressLocation.setShippingAddress(cartEvent.getLocation().getShippingAddress());
            addressLocation.setContactInfo(cartEvent.getLocation().getContactInfo());
            addressLocation.setId(cartEvent.getLocation().getId());
            addressLocation.setLocationCount(1);



            int previousCount = (locationMap.containsKey(cartEvent.getProductId()+cartEvent.getLocation().getId()))?
                locationMap.get(cartEvent.getProductId()+cartEvent.getLocation().getId()).getLocationCount() : 0 ;

            int count = previousCount    +  (cartEvent.getCartEventType().equals(CartEventType.ADD_LOCATION) ? 1 :
                (cartEvent.getCartEventType().equals(CartEventType.UPDATE_LOCATION) ? 0 : -1));

            addressLocation.setLocationCount(count);
            locationMap.put(cartEvent.getProductId()+cartEvent.getLocation().getId(),addressLocation);





        }


        // Return the updated state of the aggregate to the reactive stream's reduce method
        return this;
    }


    /**
     * Determines whether or not the {@link CartEvent} is a terminal event, causing the
     * stream to end while generating an aggregate {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.ShoppingCart}
     *
     * @param eventType is the {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.CartEventType} to evaluate
     * @return a flag indicating whether or not the event is terminal
     */
    public static Boolean isTerminal(CartEventType eventType) {
        return (eventType == CartEventType.CLEAR_CART || eventType == CartEventType.CHECKOUT);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productMap=" + productMap +
                ", catalog=" + catalog +
                ", lineItems=" + lineItems +
                '}';
    }
}
