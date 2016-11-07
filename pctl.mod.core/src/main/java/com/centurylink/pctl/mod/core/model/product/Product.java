package com.centurylink.pctl.mod.core.model.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Product Bean class
 *
 * @author Begin.samuel
 */


@Document(collection = "products")
public class Product implements Serializable {
    /**
     * updatedAt of Product
     */
    private String updatedAt;
    /**
     * descriptionHtml of Product
     */
    private String descriptionHtml;
    /**
     * displayImage of Product
     */
    private String displayImage;
    /**
     * id of Product
     */
    @Id
    private String _id;

    /**
     * createdAt of Product
     */
    private String createdAt;
    /**
     * List of terms of Product
     */
    private List<Terms> terms;
    /**
     * name of Product
     */
    private String name;

    /**
     * productVariants List of Product
     */
    private List<ProductVariants> productVariants;


    /**
     * productType of Product
     */
    private String productType;
    /**
     * productId of Product
     */
    private String productId;

    /**
     * updatedAt of Product
     *
     * @return updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * set method for updatedAt
     *  @param  updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Description of the Product
     *
     * @return descriptionHtml
     */
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    /**
     * set method for descriptionHtml
     *   @param descriptionHtml
     */
    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    /**
     * id of the Product
     *
     * @return _id
     */
    public String get_id() {
        return _id;
    }

    /**
     *
     * set method for id
     * @param id
     */
    public void set_id(String id) {
        this._id = id;
    }

    /**
     * displayImage of Product
     *
     * @return displayImage
     */
    public String getDisplayImage() {
        return displayImage;
    }

    /**
     * set method for displayImage
     *   @param displayImage
     */
    public void setDisplayImage(String displayImage) {
        this.displayImage = displayImage;
    }

    /**
     * createdAt of Product
     *
     * @return createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * set method for createdAt
     *   @param createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Terms of Product
     *
     * @return Terms , list of Terms
     */
    public List<Terms> getTerms() {
        return terms;
    }

    /**
     * set method for terms list
     *   @param terms
     */
    public void setTerms(List<Terms> terms) {
        this.terms = terms;
    }

    /**
     * name of  the Product
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for name
     *   @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    /**
     * set method for List of variants
     *   @param variants
     */
    public void setVariants(List<ProductVariants> variants) {
        this.productVariants = productVariants;
    }

    /**
     * productType of Product
     *
     * @return productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * set method for productId
     * @param  productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * productId of the Product
     * productId getmethod()
     *
     * @return productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * set method for productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Overrided toString() method
     */
    @Override
    public String toString() {
        return "Product {" +
            "updatedAt = " + updatedAt + ", " +
            "descriptionHtml = " + descriptionHtml + "," +
            " _id = " + _id + ", " +
            "displayImage = " + displayImage + ", " +
            "createdAt = " + createdAt + ", " +
            "terms = " + terms + "," +
            "name = " + name + ", " +
            "productVariants = " + productVariants + "," +
            "productType = " + productType + "," +
            "productId = " + productId + "}";
    }
}
