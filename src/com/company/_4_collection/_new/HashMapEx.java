package com.company._4_collection._new;

import java.util.HashMap;

public class HashMapEx {

  //region hashmap ex1
  public static void main(String[] args) {
    HashMap<String, String> hashMap = new HashMap<>();

    hashMap.put("3", "3");
    hashMap.put("2", "2");
    hashMap.put("1", "1");

    for (var entry : hashMap.entrySet()) {
      System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
    }

  }
  //endregion

}
