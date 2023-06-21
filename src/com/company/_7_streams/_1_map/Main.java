package com.company._7_streams._1_map;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Hello");
        list.add(" ");
        list.add("Streams");
        list.add("!");

        var result = list.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(result);
    }

}
