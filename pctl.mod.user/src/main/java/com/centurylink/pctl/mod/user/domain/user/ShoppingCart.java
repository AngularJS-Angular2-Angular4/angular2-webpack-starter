package com.centurylink.pctl.mod.user.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCart {

    public ShoppingCart(@JsonProperty("lineItems") List<LineItem> lineItems) {
        this.lineItems = lineItems;
        this.cartId = "cartId";
    }

    public ShoppingCart() {

    }
    private List<LineItem> lineItems = new ArrayList<>();
    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
