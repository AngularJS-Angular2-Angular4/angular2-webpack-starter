package com.centurylink.pctl.mod.cart.domain.ShoppingCart;
import com.centurylink.pctl.mod.core.model.address.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
/**
 * Created by nagavenkatakirang on 21-10-2016.
 */
@Document(collection = "cart_events")
public class CartEvent implements Serializable
{
    @Id
    private String id;
    private String cartId;
    private CartEventType cartEventType;
    private String productId;
    private Integer quantity;
    private AddressLocation location;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTemplateName() {
        return productTemplateName;
    }

    public void setProductTemplateName(String productTemplateName) {
        this.productTemplateName = productTemplateName;
    }

    public String getProductTemplateId() {
        return productTemplateId;
    }

    public void setProductTemplateId(String productTemplateId) {
        this.productTemplateId = productTemplateId;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    //added as per ng2
    private String productName;
    private String productTemplateName;
    private String productTemplateId;
    private String unitPrice;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public CartEvent() {

    }

    public CartEvent(String id, CartEventType cartEventType, String productId, Integer quantity) {
        this.id = id;
        this.cartEventType = cartEventType;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartEvent(CartEventType cartEventType) {
        this.cartEventType = cartEventType;
    }

    public CartEvent(CartEventType cartEventType, String productId, Integer quantity) {
        this.cartEventType = cartEventType;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;// != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CartEventType getCartEventType() {
        return cartEventType;
    }

    public void setCartEventType(CartEventType cartEventType) {
        this.cartEventType = cartEventType;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartEvent{" +
            "id=" + id +
            ", cartEventType=" + cartEventType +
            ", productId='" + productId + '\'' +
            ", quantity=" + quantity +
            '}';
    }

    public AddressLocation getLocation() {
        return location;
    }

    public void setLocations(AddressLocation location) {
        this.location = location;
    }
}
