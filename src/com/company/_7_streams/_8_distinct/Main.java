package com.company._7_streams._8_distinct;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 1, 2, 3, 3, 4, 5, 6);

        var result = s1.distinct().collect(Collectors.toList());
        System.out.println(result);
    }

}
