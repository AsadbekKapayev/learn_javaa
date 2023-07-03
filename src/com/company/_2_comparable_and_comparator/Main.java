package com.company._2_comparable_and_comparator;

import java.util.Comparator;

public class Main<T> {

  public static void main(String[] args) {

  }

}

class Test1 implements Comparable {

  @Override
  public int compareTo(Object o) {
    return 0;
  }

}

class Test2 implements Comparator {

  @Override
  public int compare(Object o, Object t1) {
    return 0;
  }
}
