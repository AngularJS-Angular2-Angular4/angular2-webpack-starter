package com.centurylink.pctl.mod.cart.domain.ShoppingCart;

import com.centurylink.pctl.mod.core.model.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by nagavenkatakirang on 02-11-2016.
 */
public class AddressLocation implements Serializable{



    private String id;
    private Address serviceAddress;
    private Address shippingAddress;
    private ContactInfo contactInfo;


    @JsonIgnore
    private int locationCount;


    public AddressLocation(){}



    public AddressLocation(String id, Address serviceAddress, Address shippingAddress) {
        this.id = id;
        this.serviceAddress = serviceAddress;
        this.shippingAddress = shippingAddress;
        this.locationCount = 1;
    }

    public AddressLocation(String id, Address serviceAddress, Address shippingAddress, ContactInfo contactInfo) {
        this.id = id;
        this.serviceAddress = serviceAddress;
        this.shippingAddress = shippingAddress;
        this.contactInfo = contactInfo;
        this.locationCount = 1;
    }

    public AddressLocation(String id, Address serviceAddress, Address shippingAddress, ContactInfo contactInfo, int locationCount) {
        this.id = id;
        this.serviceAddress = serviceAddress;
        this.shippingAddress = shippingAddress;
        this.contactInfo = contactInfo;
        this.locationCount = locationCount;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Address getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(Address serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    public int getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(int locationCount) {
        this.locationCount = locationCount;
    }






}
