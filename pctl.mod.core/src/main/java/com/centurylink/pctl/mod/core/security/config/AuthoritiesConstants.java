package com.centurylink.pctl.mod.core.security.config;

/**
 * AuthoritiesConstants class is
 * Final class <br>
 * Constants for Spring Security authorities.
 * @author  Begin
 */
public final class AuthoritiesConstants {

    /**
     * AuthoritiesConstants required constants
     */
    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";

    /**
     * AuthoritiesConstants constructor as private
     */
    private AuthoritiesConstants() {
    }
}
