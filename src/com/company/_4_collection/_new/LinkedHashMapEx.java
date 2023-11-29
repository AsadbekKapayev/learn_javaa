package com.company._4_collection._new;

import java.util.LinkedHashMap;

public class LinkedHashMapEx {

  //region ex1
  public static void main(String[] args) {
    var linkedHashMap = new LinkedHashMap<String, String>();

    linkedHashMap.put("3", "3");
    linkedHashMap.put("2", "2");
    linkedHashMap.put("1", "1");

    for (var entry : linkedHashMap.entrySet()) {
      System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
    }

  }
  //endregion

}
