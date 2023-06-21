package com.company._7_streams._12_grouping_partioning;

import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        List<User> users = List.of(
                User.of(1, 12),
                User.of(1, 14),
                User.of(2, 14),
                User.of(2, 15), User.of(3, 15),
                User.of(3, 11),
                User.of(1, 11)
        );

        var result = users.stream().collect(Collectors.partitioningBy(x -> x.id > 2));

        result.forEach((x, y) -> {
            System.out.println("id :: " + x + ", user :: " + y);
        });

    }

}