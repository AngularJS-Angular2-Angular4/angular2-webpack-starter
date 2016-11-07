package com.centurylink.pctl.mod.cart.domain.ShoppingCart;


import com.centurylink.pctl.mod.core.model.product.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by nagavenkatakirang on 21-10-2016.
 */


public class Catalog implements Serializable {

    private Long id;

    public Set<LineItem> getProducts() {
        return products;
    }

    public void setProducts(Set<LineItem> products) {
        this.products = products;
    }

    private Set<LineItem> products;


    private String name;

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
