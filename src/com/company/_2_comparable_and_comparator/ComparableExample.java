package com.company._2_comparable_and_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableExample {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();

    cars.add(new Car(1990, "Ferrari 360 Spider", 310));
    cars.add(new Car(1990, "Ferrari 360 Spider", 311));
    cars.add(new Car(1990, "Ferrari 360 Spider", 309));
    cars.add(new Car(2012, "Lamborghini Gallardo", 290));
    cars.add(new Car(2010, "Bugatti Veyron", 350));

//    example 1
//    Collections.sort(cars);
//    System.out.println(cars);

    cars.sort(new ManufactureYearComparator()
            .thenComparing(new MaxSpeedComparator()));

    System.out.println(cars);
  }

}

/*class Car implements Comparable<Car> {

  private int manufactureYear;
  private String model;
  private int maxSpeed;

  public Car(int manufactureYear, String model, int maxSpeed) {
    this.manufactureYear = manufactureYear;
    this.model = model;
    this.maxSpeed = maxSpeed;
  }

  public int compareTo(Car o) {
    return this.maxSpeed - o.maxSpeed;
  }

  @Override
  public String toString() {
    return "Car{" +
            "manufactureYear=" + manufactureYear +
            ", model='" + model + '\'' +
            ", maxSpeed=" + maxSpeed +
            '}';
  }

  public int getManufactureYear() {
    return manufactureYear;
  }

  public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}*/

class Car {

  private int manufactureYear;
  private String model;
  private int maxSpeed;

  public Car(int manufactureYear, String model, int maxSpeed) {
    this.manufactureYear = manufactureYear;
    this.model = model;
    this.maxSpeed = maxSpeed;
  }

  @Override
  public String toString() {
    return "Car{" +
            "manufactureYear=" + manufactureYear +
            ", model='" + model + '\'' +
            ", maxSpeed=" + maxSpeed +
            '}';
  }

  public int getManufactureYear() {
    return manufactureYear;
  }

  public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}

class ManufactureYearComparator implements Comparator<Car> {

  @Override
  public int compare(Car car1, Car car2) {
    return car1.getManufactureYear() - car2.getManufactureYear();
  }

}

class MaxSpeedComparator implements Comparator<Car> {

  @Override
  public int compare(Car car1, Car car2) {
    return car1.getMaxSpeed() - car2.getMaxSpeed();
  }

}
