package com.centurylink.pctl.mod.core.model.product;

/**
 * PriceInfo Bean class
 *
 * @author Begin.samuel
 */
public class PriceInfo {
    /**
     * term of Product's price info
     */

    private String term;
    /**
     * ctl of Product's price info
     */
    private String ctl;
    /**
     * own of Product's price info
     */
    private String own;

    /**
     * displayImage of Product's price info
     * @return term
     */

    public String getTerm() {
        return term;
    }

    /**
     * set method for term of Product's price info
     *
     * @param term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * displayImage of Product
     * @return ctl
     */
    public String getCtl() {
        return ctl;
    }

    /**
     * set method for ctl of Product's price info
     *
     * @param ctl
     */
    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    /**
     * displayImage of Product
     * @return own
     */
    public String getOwn() {
        return own;
    }

    /**
     * set method for own of Product's price info
     *
     * @param own
     */
    public void setOwn(String own) {
        this.own = own;
    }

    /**
     * overrided toString() method
     */
    @Override
    public String toString() {
        return "Price [term = " + term + ", ctl = " + ctl + ", own = " + own + "]";
    }


}
