package com.centurylink.pctl.mod.user.domain.user;

import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.model.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagavenkatakirang on 21-10-2016.
 */


public class LineItem {
    private String productId;
    private Product product;
    private Integer quantity;
    //added as per ng2
    private String productName;
    private String productTemplateName;
    private String productTemplateId;
    private Double unitPrice;
    private List<Address> locations = new ArrayList<Address>();

    public List<Address> getLocations() {
        return locations;
    }

    public void setLocations(List<Address> locations) {
        this.locations = locations;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LineItem(String productId, Product product, Integer quantity) {
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
    }

    public LineItem(@JsonProperty("productId") String productId,
                    @JsonProperty("product")Product product,
                    @JsonProperty("quantity")Integer quantity,
                    @JsonProperty("locations")List<Address> locations) {
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
        this.locations = locations;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LineItem{" +
            "productId='" + productId + '\'' +
            ", product=" + product +
            ", quantity=" + quantity +
            '}';
    }
}
