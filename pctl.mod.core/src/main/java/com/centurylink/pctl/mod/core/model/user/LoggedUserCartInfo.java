package com.centurylink.pctl.mod.core.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sakthivel-s on 01-11-2016.
 */
public class LoggedUserCartInfo {

    private int cartState;
    private String shoppingCartId;
    private int cartItemCount;

    public LoggedUserCartInfo(@JsonProperty("cartState") int cartState,
                               @JsonProperty("shoppingCartId") String shoppingCartId,
                               @JsonProperty("cartItemCount") int cartItemCount) {
        this.cartState = cartState;
        this.shoppingCartId = shoppingCartId;
        this.cartItemCount = cartItemCount;
    }

    public int getCartState() {
        return cartState;
    }

    public void setCartState(int cartState) {
        this.cartState = cartState;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getCartItemCount() {
        return cartItemCount;
    }

    public void setCartItemCount(int cartItemCount) {
        this.cartItemCount = cartItemCount;
    }
}
