package com.company._7_streams._15_limit;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3, 4, 5);

        var result = s1.limit(2).collect(Collectors.toList());

        System.out.println(result);
    }

}
