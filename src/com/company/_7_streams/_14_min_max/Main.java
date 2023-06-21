package com.company._7_streams._14_min_max;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3, 4, 5, 6);
        var s2 = Stream.of(1, 2, 3, 4, 5, 6);

        var result = s1.min(Integer::compareTo).orElseThrow();

        System.out.println(result);

        var max = s2.max(Integer::compareTo).orElseThrow();

        System.out.println(max);
    }

}
