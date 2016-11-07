package com.centurylink.pctl.mod.address.domain.address;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum class for AddressType
 *
 * @author Haribabu.ka
 */

public enum AddressType {
    CIVIC, POSTAL;

    /**
     * List created to add AddressType available for address
     */
    private final static List<String> addressType = new ArrayList<>();

    /**
     * static method adding available addressType in a list
     */
    static {
        for (AddressType type : AddressType.values()) {
            addressType.add(type.name());
        }
    }

    /**
     * getValueOf() method gives the AddressType of address
     *
     * @param name , AddressType given as input
     * @return type, AddressType as  CIVIC or POSTAL returns
     */
    public static AddressType getValueOf(String name) {
        for (AddressType type : AddressType.values()) {
            if (type.name().equalsIgnoreCase(name))
                return type;
        }
        return null;
    }

}
