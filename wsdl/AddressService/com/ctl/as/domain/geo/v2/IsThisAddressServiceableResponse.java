
package com.ctl.as.domain.geo.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsThisAddressServiceableResult" type="{http://geo.domain.as.ctl.com/v2/Types/Response}IsThisAddressServiceableResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isThisAddressServiceableResult"
})
@XmlRootElement(name = "IsThisAddressServiceableResponse")
public class IsThisAddressServiceableResponse {

    @XmlElementRef(name = "IsThisAddressServiceableResult", namespace = "http://geo.domain.as.ctl.com/v2", type = JAXBElement.class, required = false)
    protected JAXBElement<com.ctl.as.domain.geo.v2.types.response.IsThisAddressServiceableResponse> isThisAddressServiceableResult;

    /**
     * Gets the value of the isThisAddressServiceableResult property.
     *
     * @return
     *     possible object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link com.ctl.as.domain.geo.v2.types.response.IsThisAddressServiceableResponse }{@code >}
     *
     */
    public JAXBElement<com.ctl.as.domain.geo.v2.types.response.IsThisAddressServiceableResponse> getIsThisAddressServiceableResult() {
        return isThisAddressServiceableResult;
    }

    /**
     * Sets the value of the isThisAddressServiceableResult property.
     *
     * @param value
     *     allowed object is
     *     {@link javax.xml.bind.JAXBElement }{@code <}{@link com.ctl.as.domain.geo.v2.types.response.IsThisAddressServiceableResponse }{@code >}
     *
     */
    public void setIsThisAddressServiceableResult(JAXBElement<com.ctl.as.domain.geo.v2.types.response.IsThisAddressServiceableResponse> value) {
        this.isThisAddressServiceableResult = value;
    }

}
