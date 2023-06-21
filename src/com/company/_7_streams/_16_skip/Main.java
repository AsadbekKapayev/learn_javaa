package com.company._7_streams._16_skip;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3);

        var r = s1.skip(2).collect(Collectors.toList());

        System.out.println(r);
    }

}
