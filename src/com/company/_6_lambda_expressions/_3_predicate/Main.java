package com.company._6_lambda_expressions._3_predicate;

// import java.util.function.Predicate;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        testStr("asd", (a) -> a != null && a.trim().length() > 0);
    }

    static void testStr(String str, Predicate<String> pr) {
        if (pr.test(str)) {
            System.out.println("str :: " + str);
        }
    }

}
