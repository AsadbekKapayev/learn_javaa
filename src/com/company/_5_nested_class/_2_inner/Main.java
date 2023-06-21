package com.company._5_nested_class._2_inner;

public class Main {

    public static void main(String[] args) {
        var v = new Car("black", 4, 400);

        var engine = v.new Engine(100);
        v.setEngine(engine);

        System.out.println(v);

        var c2 = new Car("yellow", 4, 100).new Engine(150);

        System.out.println(c2);
    }

}
