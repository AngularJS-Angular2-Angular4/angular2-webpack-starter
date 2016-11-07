package com.centurylink.pctl.mod.cart.domain.ShoppingCart;

import com.centurylink.pctl.mod.core.model.address.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import com.centurylink.pctl.mod.core.model.user.User;
import com.centurylink.pctl.mod.core.model.product.*;
/**
 * The {@link ShoppingCartServiceV1} implements business logic for aggregating the state of
 * a user's actions represented by a sequence of {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.CartEvent}. The generated aggregate
 * uses event sourcing to produce a {@link com.centurylink.pctl.mod.cart.domain.ShoppingCart.ShoppingCart} containing a collection of
 * {@link //demo.cart.LineItem}.
 *
 */
/**
 * Created by nagavenkatakirang on 21-10-2016.
 */
@Service
public class ShoppingCartServiceV1 {
   /* @Autowired
    ProductRepository productRepository;*/
    //public static final double TAX = .06;
    private final Log log = LogFactory.getLog(ShoppingCartServiceV1.class);
@Autowired
CartEventRepository cartEventRepository;
 //   private RestTemplate restTemplate;

   /* @Autowired
    public ShoppingCartServiceV1(CartEventRepository cartEventRepository) {
        this.cartEventRepository = cartEventRepository;
    }*/
    public ShoppingCartServiceV1(){

    }
    /**
     * Get the authenticated user from the user service
     *
     * @return the currently authenticated user
     */
    public User getAuthenticatedUser() {

        User user = new User();
        user.setId("0");
        return user;
    }

    /**
     * Adds a shopping cart event for the authenticated user
     *
     * @param cartEvent is the event detailing the action performed by the user
     * @return a flag indicating whether the result was a success
     */
    public Boolean addCartEvent(CartEvent cartEvent) {
        cartEventRepository.save(cartEvent);
        return true;
    }


    /**
     * Aggregate the cart events of a user and return a {@link ShoppingCart} object
     *
     * @param cartId    is the cart id to retrieve the shopping cart for
     * @param catalog is the catalog used to generate the shopping cart
     * @return a shopping cart representing the aggregate state of the user's cart
     * @throws Exception
     */
    public ShoppingCart aggregateCartEvents(String cartId,Catalog catalog) throws Exception {
        Flux<CartEvent> cartEvents =
                Flux.fromStream(cartEventRepository.getCartEventStreamByCartId(cartId));

        // Aggregate the state of the shopping cart
        ShoppingCart shoppingCart = cartEvents
                .takeWhile(cartEvent -> !ShoppingCart.isTerminal(cartEvent.getCartEventType()))
                .reduceWith(() -> new ShoppingCart(catalog), ShoppingCart::incorporate)
                .get();

        shoppingCart.getLineItems();
        log.info("Inside aggregateCartEvents()------->>> "+shoppingCart);
        System.out.println("sysout Inside aggregateCartEvents()------->>> "+shoppingCart);
        return shoppingCart;
    }



    /**
     * Aggregate the cart events of a user and return a {@link ShoppingCart} object
     *
     * @param cartId    is the cart's Id to retrieve the shopping cart for
     * @return a shopping cart representing the aggregate state of the user's cart
     * @throws Exception
     */
    public ShoppingCart aggregateCartEvents(String cartId) throws Exception {

        Flux<CartEvent> cartEvents =
            Flux.fromStream(cartEventRepository.getCartEventStreamByCartId(cartId));

        // Aggregate the state of the shopping cart
        ShoppingCart shoppingCart = cartEvents
            .takeWhile(cartEvent -> !ShoppingCart.isTerminal(cartEvent.getCartEventType()))
            .reduceWith(() -> new ShoppingCart(), ShoppingCart::incorporateWithLocation)
            .get();

        shoppingCart.getLineItems();
        log.info("Inside aggregateCartEvents()------->>> "+shoppingCart);
        System.out.println("sysout Inside aggregateCartEvents()------->>> "+shoppingCart);
        return shoppingCart;
    }







    public ShoppingCart getShoppingCart(String cartId) throws Exception {
        ShoppingCart shoppingCart = null;
        if (cartId != null) {
            //Catalog catalog =getCatalog();
            //shoppingCart = aggregateCartEvents(cartId, catalog,null);
            shoppingCart = aggregateCartEvents(cartId);
        }
        log.info("Inside getShoppingCart() method:::::::::::::::: "+shoppingCart);
        return shoppingCart;
    }


}
