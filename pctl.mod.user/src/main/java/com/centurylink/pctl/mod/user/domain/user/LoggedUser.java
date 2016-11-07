/*
package com.centurylink.pctl.mod.user.domain.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")

public class LoggedUser implements Serializable {

    private String authToken;

    private String id;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    private String login;

    private String password;

    @Field("first_name")
    private String firstName;

    //    @Size(max = 50)
    @Field("last_name")
    private String lastName;

    @Field("email")
    private String email;

    private String activated;

    private String fingerPrint;

    private Set<LoggedUserAuthority> authorities = new HashSet<LoggedUserAuthority>();

    private CartInfo cartInfo ;

    public LoggedUser() {

    }

    public CartInfo getCartInfo() {
        return cartInfo;
    }

    public void setCartInfo(CartInfo cartInfo) {
        this.cartInfo = cartInfo;
    }

    public String getFingerPrint() {

        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }


    @JsonCreator
  public LoggedUser(@JsonProperty("id")String id, @JsonProperty("login")String login, @JsonProperty("password")String password, @JsonProperty("firstName")String firstName,
                    @JsonProperty("lastName")String lastName, @JsonProperty("email")String email, @JsonProperty("activated") String activated, @JsonProperty("authorities") Set<LoggedUserAuthority> authorities,
                    @JsonProperty("cartInfo")String cartInfo  ) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.activated = activated;
    this.authorities = authorities;
  }


    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<LoggedUserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<LoggedUserAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

      LoggedUser user = (LoggedUser) o;

        if (!login.equals(user.login)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", activated='" + activated + '\'' +
            "}";
    }
}
*/
