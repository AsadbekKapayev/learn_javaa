package com.company._4_collection._new;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapEx {

  //region ex1
  public static void main(String[] args) {
    var treeMap = new TreeMap<String, String>(new TreeMapComparator());

    treeMap.put("3", "3");
    treeMap.put("1", "1");
    treeMap.put("2", "2");

    for (var entry : treeMap.entrySet()) {
      System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
    }

  }
  //endregion

  static class TreeMapComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
      return Integer.parseInt(s) - Integer.parseInt(t1);
    }

  }

}
