package com.centurylink.pctl.mod.core.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Class representing the Spring Security authenticated user.
 *
 * @author Begin
 * @see UserDetails
 *
 */
public class CustomUserDetails implements UserDetails {


    private static final long serialVersionUID = 1L;
    /**
     * user id
     */
    private final String id;
    /**
     * user password
     */
    private final String password;
    /**
     * user username
     */
    private final String username;
    /**
     * user authorities
     */
    private final Set<GrantedAuthority> authorities;
    /**
     * user accountNonExpired
     */
    private final boolean accountNonExpired;
    /**
     * user accountNonLocked
     */
    private final boolean accountNonLocked;
    /**
     * user credentialsNonExpired
     */
    private final boolean credentialsNonExpired;
    /**
     * user enabled
     */
    private final boolean enabled;

    /**
     * CustomUserDetails constructor with arugments
     * @param id
     * @param username
     * @param password
     * @param authorities
     * @param accountNonExpired
     * @param accountNonLocked
     * @param credentialsNonExpired
     * @param enabled
     */
    public CustomUserDetails(String id, String username, String password, Set<GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked,
            boolean credentialsNonExpired, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    /**
     * getId() method for id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * getAuthorities()
     * @return authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * getPassword()
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * getUsername()
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * isAccountNonExpired()
     * @return accountNonExpired
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * isAccountNonLocked()
     * @return accountNonLocked
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     *
     * isCredentialsNonExpired()
     * @return credentialsNonExpired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * isEnabled()
     * @return enabled
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * isUserInRole()
     * @param authority
     * @return boolean value
     */
    public boolean isUserInRole(String authority) {
        return authorities.contains(new SimpleGrantedAuthority(authority));
    }

    /**
     * overridden toString () method
     * @return
     */
    @Override
    public String toString() {
        return "CustomUserDetails{" + id + ',' + username + ',' + authorities + '}';
    }
}
