package com.company._7_streams._18_parallel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var l1 = List.of(1, 2, 3, 4, 5);

        var r = l1.parallelStream().sorted(Comparator.reverseOrder()).reduce((x, y) -> x / y).orElseThrow();

        System.out.println(r);
    }

}
