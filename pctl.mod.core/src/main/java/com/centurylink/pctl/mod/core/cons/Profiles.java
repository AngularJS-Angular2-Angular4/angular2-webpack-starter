package com.centurylink.pctl.mod.core.cons;

/**
 *  Enum class for different environments
 * @author Begin Samuel
 */

public enum Profiles {

    /**
     * Dev and prod <br>
     * enums
     */
    DEV("dev"),
    PROD("prod");

    /**
     * profileName
     */
    private String profileName;

    /**
     * profiles constructor
     * @param profileName
     */
    Profiles(String profileName) {
        this.profileName = profileName;
    }

    /**
     * getProfileName() returns profileName
     * @return profileName
     */
    public String getProfileName() {
        return profileName;
    }
}
