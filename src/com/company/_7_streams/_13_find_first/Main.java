package com.company._7_streams._13_find_first;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s = Stream.of(1, 2, 3, 4, 5);

        var result = s.findFirst().orElseThrow();

        System.out.println(result);
    }

}
