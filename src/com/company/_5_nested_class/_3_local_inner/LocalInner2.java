package com.company._5_nested_class._3_local_inner;

public class LocalInner2 {

    public static void main(String[] args) {

        class Multiplication implements Math2 {

            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }

        }

        var m = new Multiplication();

        System.out.println(m.doOperation(3,4));

    }

}

interface Math2 {
    int doOperation(int a, int b);
}
