package com.centurylink.pctl.mod.cart.controllers.rest;
import com.centurylink.pctl.mod.cart.domain.ShoppingCart.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
/**
 * Created by nagavenkatakirang on 17-10-2016.
 */
@RequestMapping("/cart")
@RestController
public class PctlApiCartRestController {
    private static final Logger log = LoggerFactory.getLogger(PctlApiCartRestController.class);
    @Autowired
    public com.centurylink.pctl.mod.cart.domain.ShoppingCart.ShoppingCartServiceV1 shoppingCartService;
    @Autowired
    public PctlApiCartRestController(ShoppingCartServiceV1 shoppingCartService){
        this.shoppingCartService=shoppingCartService;
    }
    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public ResponseEntity addCartEvent(@RequestBody CartEvent cartEvent) throws Exception {
        return Optional.ofNullable(shoppingCartService.addCartEvent(cartEvent))
            .map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
            .orElseThrow(() -> new Exception("Could not find shopping cart"));
    }

    @RequestMapping(path = "/cart/{cartId}", method = RequestMethod.GET)
    public ResponseEntity getCartWithLocation(@PathVariable String cartId) throws Exception {
        return Optional.ofNullable(shoppingCartService.getShoppingCart(cartId))
            .map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
            .orElseThrow(() -> new Exception("Could not find shopping cart"));
    }
}
