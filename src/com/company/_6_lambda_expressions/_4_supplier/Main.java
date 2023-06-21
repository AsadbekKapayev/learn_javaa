package com.company._6_lambda_expressions._4_supplier;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        useSupplier(() -> "Hello Supplier!");
    }

    static void useSupplier(Supplier<String> s) {
        System.out.println(s.get());
    }

}
