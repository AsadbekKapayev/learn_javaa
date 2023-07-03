package com.company._4_collection._4_equals_hashcode;

import java.util.Objects;

public class Main {

  public static void main(String[] args) {

  }

}

class User {
  private Long id;
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
