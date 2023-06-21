package com.company._5_nested_class._1_static;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int countOfObjects = 1;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public static class Engine {
        int power;
        static int countOfObjectsNested;

        public Engine(int power) {
            this.power = power;
            countOfObjectsNested = countOfObjects;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "power=" + power +
                    ", countOfObjectsNested=" + countOfObjectsNested +
                    '}';
        }

    }

}
