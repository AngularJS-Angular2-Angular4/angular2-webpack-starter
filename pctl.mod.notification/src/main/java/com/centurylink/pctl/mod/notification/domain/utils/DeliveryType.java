package com.centurylink.pctl.mod.notification.domain.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pulapakas
 */
public enum DeliveryType {
    EMAIL, MESSAGE;

    /**
     * List created to add deliveryTypes available for notification
     */
    private final static List<String> deliveryTypes = new ArrayList<>();

    /**
     * static method adding available deliverytype in a list
     */
    static {
        for (DeliveryType type : DeliveryType.values()) {
            deliveryTypes.add(type.name());
        }
    }

    /**
     *getValueOf() method gives the DeliveryType of notification
     * @param name , DeliveryType given as input
     * @return type, DeliveryType as  EMAIL or MESSAGE returns
     */
    public static DeliveryType getValueOf(String name) {
        if (name != null) {
            for (DeliveryType type : DeliveryType.values()) {
                if (type.name().equalsIgnoreCase(name))
                    return type;
            }
        }
        return null;
    }

    /**
     *
     * getSupportedValues() method deliveryType is converted toString and returned.
     */
    public static String getSupportedValues() {
        return deliveryTypes.toString();
    }
}

