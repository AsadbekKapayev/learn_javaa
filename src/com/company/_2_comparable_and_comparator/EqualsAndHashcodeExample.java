package com.company._2_comparable_and_comparator;

import java.util.Objects;

public class EqualsAndHashcodeExample {

  private String model;
  private int manufactureYear;
  private int dollarPrice;

  public EqualsAndHashcodeExample(String model, int manufactureYear, int dollarPrice) {
    this.model = model;
    this.manufactureYear = manufactureYear;
    this.dollarPrice = dollarPrice;
  }

//  Мой пример
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    Car car = (Car) o;
//
//    return manufactureYear == car.manufactureYear && dollarPrice == car.dollarPrice && model.equals(car.model);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = model == null ? 0 : model.hashCode();
//    result = 31 * result + manufactureYear;
//    result = 31 * result + dollarPrice;
//    return result;
//  }

  // auto generate
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EqualsAndHashcodeExample car = (EqualsAndHashcodeExample) o;
    return manufactureYear == car.manufactureYear && dollarPrice == car.dollarPrice && Objects.equals(model, car.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, manufactureYear, dollarPrice);
  }


}
