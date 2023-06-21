package com.company._5_nested_class._2_inner;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int countOfObjects = 1;

    public Car(String color, int doorCount, int power) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(power);

        System.out.println(this.engine.power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public class Engine {
        private int power;

        public Engine(int power) {
            this.power = power;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "power=" + power +
                    '}';
        }

    }

}
