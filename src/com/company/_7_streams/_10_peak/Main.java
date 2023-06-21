package com.company._7_streams._10_peak;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3, 4, 5, 6);

        var result = s1.peek(x -> Integer.valueOf(5)).collect(Collectors.toList());

        System.out.println(result);
    }

}
