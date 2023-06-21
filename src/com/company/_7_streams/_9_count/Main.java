package com.company._7_streams._9_count;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(1, 2, 3, 4, 5, 6);

        var result = s1.count();

        System.out.println(result);
    }

}
