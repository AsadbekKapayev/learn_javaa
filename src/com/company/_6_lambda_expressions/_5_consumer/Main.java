package com.company._6_lambda_expressions._5_consumer;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        useConsumer(System.out::println);
    }

    static void useConsumer(Consumer<String> c) {
        var str = "Hello Consumer!";
        c.accept(str);
    }

}
