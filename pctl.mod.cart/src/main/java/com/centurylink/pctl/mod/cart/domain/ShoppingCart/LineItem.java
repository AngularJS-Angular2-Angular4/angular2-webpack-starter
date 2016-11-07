package com.centurylink.pctl.mod.cart.domain.ShoppingCart;

import com.centurylink.pctl.mod.core.model.address.Address;
import com.centurylink.pctl.mod.core.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagavenkatakirang on 21-10-2016.
 */


public class LineItem {




    @JsonIgnore
    private String _id;


    private String productId;
    private Integer quantity;
    //added as per ng2
    private String productName;
    private String productTemplateName;
    private String productTemplateId;
    private String unitPrice;

    public LineItem(){

    }


    public LineItem(String _id, String productId, String productName, String productTemplateName, String productTemplateId, String unitPrice, Integer quantity) {
        this._id = _id;
        this.productId = productId;
        this.productName = productName;
        this.productTemplateName = productTemplateName;
        this.productTemplateId = productTemplateId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }


    public LineItem(String _id, String productId, String productName, String productTemplateName, String productTemplateId, String unitPrice) {
        this._id = _id;
        this.productId = productId;
        this.productName = productName;
        this.productTemplateName = productTemplateName;
        this.productTemplateId = productTemplateId;
        this.unitPrice = unitPrice;
    }

    public LineItem(String _id,String productId, Integer quantity, String productName, String productTemplateName, String productTemplateId, String unitPrice, List<AddressLocation> locations) {
        this._id = _id;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productTemplateName = productTemplateName;
        this.productTemplateId = productTemplateId;
        this.unitPrice = unitPrice;
        this.locations = locations;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    private List<AddressLocation> locations = new ArrayList<AddressLocation>();

    public List<AddressLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<AddressLocation> locations) {
        this.locations = locations;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
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
        return "LineItem{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
