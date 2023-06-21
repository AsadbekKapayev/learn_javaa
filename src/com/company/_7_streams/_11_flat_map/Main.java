package com.company._7_streams._11_flat_map;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var users = List.of(User.of("John", "1", "2"), User.of("Max", "1", "2"));

        var result = users.stream().flatMap(x -> x.data.stream()).collect(Collectors.toList());

        System.out.println(result);

    }

}

class User {
    public String name;
    public List<String> data;

    public static User of(String name, String ...data) {
        var user = new User();
        user.name = name;
        user.data = List.of(data);

        return user;
    }

}