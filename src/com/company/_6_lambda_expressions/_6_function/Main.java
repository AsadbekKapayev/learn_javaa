package com.company._6_lambda_expressions._6_function;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        System.out.println(useFunction(String::length));

    }

    static Integer useFunction(Function<String, Integer> f) {
        var str = "Hello Function!";
        return f.apply(str);
    }

}
