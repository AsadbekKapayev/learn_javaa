package com.company._7_streams._17_map_to_int;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var s1 = Stream.of(
                User.of(1, 1),
                User.of(2, 2),
                User.of(3, 3),
                User.of(4, 4),
                User.of(5, 5)
        );

        var r = s1.mapToInt(x -> x.id).boxed().collect(Collectors.toList());

        System.out.println(r);
    }

}

class User {
    public int id;
    public int age;

    public static User of(int id, int age) {
        var user = new User();

        user.id = id;
        user.age = age;

        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
