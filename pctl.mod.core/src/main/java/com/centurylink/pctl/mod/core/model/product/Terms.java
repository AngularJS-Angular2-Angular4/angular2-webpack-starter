package com.centurylink.pctl.mod.core.model.product;

/**
 * Terms Bean class
 *
 * @author Begin.samuel
 */
public class Terms {
    /**
     * Termname of Terms
     */
    private String name;

    /**
     * name of Terms
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for terms name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * frequency of Terms
     *
     * @return frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * set method for frequency
     *
     * @param frequency
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * Terms frequency of Terms
     */
    private String frequency;

    /**
     * shortCode of Terms
     *
     * @return shortCode
     */
    public String getShortCode() {
        return shortCode;
    }

    /**
     * set method for shortCode
     *
     * @param shortCode
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * shortCode of Terms
     */
    private String shortCode;
}
