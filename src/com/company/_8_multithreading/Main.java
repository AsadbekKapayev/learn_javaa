package com.company._8_multithreading;

import java.util.List;

public class Main {

  public static List<Integer> list = List.of(-1);

  public static void main(String[] args) {


    for (int i = 0; i < 5; i++) {
      list = List.of(i);

      var eList = list;

      new Thread(() -> {

        try {
          Thread.sleep(1000);
          System.out.println(eList);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }).start();

    }

  }

}
