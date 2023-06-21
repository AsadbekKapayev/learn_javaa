package com.company._7_streams._7_concat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3);
        var s2 = Stream.of(4, 5, 6);
        var result = Stream.concat(s1, s2).collect(Collectors.toList());

        System.out.println(result);
    }

}
