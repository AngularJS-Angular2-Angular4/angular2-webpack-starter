package com.centurylink.pctl.mod.core.model.address;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Address Bean class
 *
 * @author Haribabu.ka
 */
public class Address {

    /**
     * id of Address
     */
    private String id;

    /**
     * locationName of Address
     */
    @NotEmpty(message = "locationName is not Provided")
    private String locationName;

    /**
     * addressLine of Address
     */
    @NotEmpty(message = "addressLine is not Provided")
    private String addressLine;

    /**
     * street of Address
     */
    @NotEmpty(message = "street is not Provided")
    private String street;

    /**
     * city of Address
     */
    @NotEmpty(message = "city is not Provided")
    private String city;

    /**
     * country of Address
     */
    @NotEmpty(message = "country is not Provided")
    private String country;

    /**
     * state of Address
     */
    @NotEmpty(message = "state is not Provided")
    @Size(min = 2, max = 2, message = "two digit state code is expected")
    private String state;

    /**
     * zipCode of Address
     */
    @NotEmpty(message = "zipCode is not Provided")
    private String zipCode;

    /**
     * checkAddress of Address
     */
    private String checkAddress;


    public Address() {
    }

    /**
     * id of Address
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * locationName of Address
     *
     * @return locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * addressLine of Address
     *
     * @return addressLine
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * street of Address
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * country of Address
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * city of Address
     *
     * @return city
     */

    public String getCity() {
        return city;
    }

    /**
     * state of Address
     *
     * @return state
     */

    public String getState() {
        return state;
    }

    /**
     * zipCode of Address
     *
     * @return zipCode
     */

    public String getZipCode() {
        return zipCode;
    }

    /**
     * checkAddress of Address
     *
     * @return checkAddress
     */
    public String getCheckAddress() {
        return checkAddress;
    }


    /**
     * toString() method is overridden
     */
    @Override
    public String toString() {
        return "Address [id = " + id + ", locationName = " + locationName + ", addressLine = " + addressLine + ", street = " + street + ", city = " + city + ", country = " + country + ", state = " + state + ", zipCode = " + zipCode + ", checkAddress = " + checkAddress + "]";
    }
}
