package com.centurylink.pctl.mod.core.dto.commons;


/**
 * @author  Begin Samuel
 */
public class ValueObject {

    /**
     * value
     */
    private String value;

    /**
     * ValueObject() no arg constructor
     */
    public ValueObject() {
    }

    /**
     * ValueObject() string argument constructor
     * @param value
     */
    public ValueObject(String value) {
        this.value = value;
    }

    /**
     * getValue() method returns value
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * set method for value
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * equals() method overridden
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueObject that = (ValueObject) o;

        return value != null ? value.equals(that.value) : that.value == null;

    }

    /**
     *  hashcode()
     * @return hashcode returns
     */
    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
