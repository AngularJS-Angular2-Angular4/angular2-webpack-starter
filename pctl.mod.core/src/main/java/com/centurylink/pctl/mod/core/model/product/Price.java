package com.centurylink.pctl.mod.core.model.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Price Bean class
 *
 * @author Begin.samuel
 */
@Document(collection = "products_price")
public class Price extends ProductVariants implements Serializable {

    /**
     * priceid of Product
     */
    @Id
    private String _id;

    /**
     * currency of Product
     */
    private String currency;

    /**
     * id of Product
     *
     * @return id
     */
    public String get_id() {
        return _id;
    }

    /**
     * set method for price id of Product
     *
     * @param _id
     */
    public void set_id(String _id) {
        this._id = _id;
    }


    /**
     * currency details of Product price information
     *
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * set method of currency details of price product
     *
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * PriceInfo of product as list
     *
     * @return priceList
     */

    public List<PriceInfo> getPriceList() {
        return priceList;
    }

    /**
     * set method for list of PriceInfo
     *
     * @param priceList
     */
    public void setPriceList(List<PriceInfo> priceList) {
        this.priceList = priceList;
    }

    /**
     * priceList as list of PriceInfo
     */
    private List<PriceInfo> priceList;


}

