package com.centurylink.pctl.mod.core.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sakthivel-s on 01-11-2016.
 */

public class CartInfo {

  String  shoppingCartId;
  String cartStatus;

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    int cartItemCount;

    public CartInfo(@JsonProperty("shoppingCartId") String shoppingCartId,
                    @JsonProperty("cartItemCount") int cartItemCount,
                    @JsonProperty("cartStatus") String cartStatus) {
        this.shoppingCartId = shoppingCartId;
        this.cartItemCount = cartItemCount;
        this.cartStatus = cartStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartInfo)) return false;

        CartInfo cartInfo = (CartInfo) o;

        if (cartItemCount != cartInfo.cartItemCount) return false;
        if (cartStatus != null ? !cartStatus.equals(cartInfo.cartStatus) : cartInfo.cartStatus != null) return false;
        if (shoppingCartId != null ? !shoppingCartId.equals(cartInfo.shoppingCartId) : cartInfo.shoppingCartId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingCartId != null ? shoppingCartId.hashCode() : 0;
        result = 31 * result + (cartStatus != null ? cartStatus.hashCode() : 0);
        result = 31 * result + cartItemCount;
        return result;
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
