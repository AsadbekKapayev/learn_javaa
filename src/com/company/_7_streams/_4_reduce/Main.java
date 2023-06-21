package com.company._7_streams._4_reduce;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Hello");
        list.add(" ");
        list.add("Streams");
        list.add("!");

        var result = list.stream()
                .reduce((acc, ele) -> acc + ele).orElseThrow();

        System.out.println(result);
    }

}
