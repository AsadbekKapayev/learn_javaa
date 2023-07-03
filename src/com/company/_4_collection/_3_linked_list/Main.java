package com.company._4_collection._3_linked_list;

import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    var e = list.element();

    System.out.println(e);

    System.out.println(list);
  }

}
