package com.company._5_nested_class._4_anonymous;

public class Anonymous {

    int x = 0;

    public static void main(String[] args) {
        var m = new Math2() {

            int v = 10;
            private int p = 10;

            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }

        };

        System.out.println(m.doOperation(4, 4));
        System.out.println(m.v); // есть доступ к локальным переменным
        System.out.println(m.p); // есть доступ к закрытым локальным переменным
    }

}

interface Math2 {
    int doOperation(int a, int b);
}

