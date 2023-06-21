package com.company._6_lambda_expressions._1_;

public class Test {

    static void def(I i) {
        System.out.println(i.abc("Hello"));
    }

    public static void main(String[] args) {
        def(String::length);
    }

}

interface I {
    int abc(String s);
}
