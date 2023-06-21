package com.company._7_streams._3_foreach;

import java.util.ArrayList;

public class Main {

    // terminal
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Hello");
        list.add(" ");
        list.add("Streams");
        list.add("!");

        list.stream()
                .forEach(System.out::println);
    }

}
