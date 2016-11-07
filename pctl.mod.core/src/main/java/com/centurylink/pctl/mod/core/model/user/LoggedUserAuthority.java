package com.centurylink.pctl.mod.core.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by sakthivel-s on 31-10-2016.
 */
public class LoggedUserAuthority implements Serializable {

  @JsonProperty("name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public LoggedUserAuthority( @JsonProperty("name") String name){
      this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LoggedUserAuthority authority = (LoggedUserAuthority) o;

    if (name != null ? !name.equals(authority.name) : authority.name != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Authority{" +
      "name='" + name + '\'' +
      "}";
  }
}
