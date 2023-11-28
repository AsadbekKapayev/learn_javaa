package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        A b = new B();
        A c = new C();

        b.setUse();
        c.setUse();

        System.out.println(b.use);
        System.out.println(c.use);

    }
}

abstract class A {
    boolean use = false;

    public void setUse() {

        if (this instanceof B) {
            use = true;
        }

    }

}

class B extends A {

}

class C extends A {

}
