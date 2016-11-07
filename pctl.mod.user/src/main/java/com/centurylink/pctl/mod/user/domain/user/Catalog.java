package com.centurylink.pctl.mod.user.domain.user;


import com.centurylink.pctl.mod.core.model.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nagavenkatakirang on 21-10-2016.
 */


public class Catalog implements Serializable {

    private Long id;

    private Set<Product> products = new HashSet<>();

    public Catalog(@JsonProperty("id")Long id,
                   @JsonProperty("products")Set<Product> products,
                   @JsonProperty("name")String name) {
        this.id = id;
        this.products = products;
        this.name = name;
    }

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
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
                ", products=" + products +
                ", name='" + name + '\'' +
                '}';
    }
}
