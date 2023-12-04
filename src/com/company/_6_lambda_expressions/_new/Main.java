package com.company._6_lambda_expressions._new;

import java.util.function.*;

public class Main {

  public static void main(String[] args) {

    //region predicate
    Predicate<Integer> predicateValue = (x) -> x > 0;
    if (predicateValue.test(1)) {
      System.out.println("predicateValue :: x is more than 0");
    }

    BiPredicate<Integer, Integer> biPredicateValue = (x, y) -> x > y;
    if (biPredicateValue.test(2, 1)) {
      System.out.println("biPredicateValue :: x is more than y");
    }

    IntPredicate intPredicateValue = (x) -> x > 0;
    if (intPredicateValue.test(2)) {
      System.out.println("intPredicateValue :: x is more than 0");
    }

    LongPredicate longPredicate = (x) -> x > 0;
    if (longPredicate.test(2)) {
      System.out.println("longPredicate :: x is more than 0");
    }

    DoublePredicate doublePredicate = (x) -> x > 0;
    if (doublePredicate.test(2)) {
      System.out.println("doublePredicate :: x is more than 0");
    }

    //endregion

    //region supplier
    Supplier<Integer> supplier = () -> 1;
    System.out.println("supplier :: " + supplier.get());

    BooleanSupplier booleanSupplier = () -> true;
    System.out.println("booleanSupplier :: " + booleanSupplier.getAsBoolean());

    IntSupplier intSupplier = () -> 1;
    System.out.println("intSupplier :: " + intSupplier.getAsInt());

    LongSupplier longSupplier = () -> 1;
    System.out.println("longSupplier :: " + longSupplier.getAsLong());

    DoubleSupplier doubleSupplier = () -> 1;
    System.out.println("doubleSupplier :: " + doubleSupplier.getAsDouble());
    //endregion

    //region consumer
    Consumer<Integer> consumer = System.out::println;
    consumer.accept(1);

    BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + " " + y);
    biConsumer.accept(1, 1);

    IntConsumer intConsumer = System.out::println;
    intConsumer.accept(1);

    LongConsumer longConsumer = System.out::println;
    longConsumer.accept(1);

    DoubleConsumer doubleConsumer = System.out::println;
    doubleConsumer.accept(1);

    ObjIntConsumer<Integer> objIntConsumer = (x, y) -> System.out.println("x: " + x + ", y: " + y);
    objIntConsumer.accept(1, 1);

    ObjLongConsumer<Integer> objLongConsumer = (x, y) -> System.out.println("x: " + x + ", y: " + y);
    objLongConsumer.accept(1, 1);

    ObjDoubleConsumer<Integer> objDoubleConsumer = (x, y) -> System.out.println("x: " + x + ", y: " + y);
    objDoubleConsumer.accept(1, 1);
    //endregion

    //region function
    Function<Integer, Integer> function = (x) -> x;
    System.out.println("x: " + function.apply(1));

    BiFunction<Integer, Integer, Long> biFunction = (x, y) -> (long) (x + y);
    System.out.println("x: " + biFunction.apply(1, 2));

    IntFunction<Integer> intFunction = (x) -> x;
    System.out.println("x: " + intFunction.apply(1));

    LongFunction<Integer> longFunction = (x) -> (int) x;
    System.out.println("x: " + longFunction.apply(1));

    DoubleFunction<Integer> doubleFunction = (x) -> (int) x;
    System.out.println("x: " + doubleFunction.apply(1));

    IntToLongFunction intToLongFunction = (x) -> (long) x;
    System.out.println("x: " + intToLongFunction.applyAsLong(1));

    IntToDoubleFunction intToDoubleFunction = (x) -> (double) x;
    System.out.println("x: " + intToDoubleFunction.applyAsDouble(1));

    LongToIntFunction longToIntFunction = (x) -> (int) x;
    System.out.println("x: " + longToIntFunction.applyAsInt(1));

    LongToDoubleFunction longToDoubleFunction = (x) -> (double) x;
    System.out.println("x: " + longToDoubleFunction.applyAsDouble(1));

    DoubleToIntFunction doubleToIntFunction = (x) -> (int) x;
    System.out.println("x: " + doubleToIntFunction.applyAsInt(1));

    DoubleToLongFunction doubleToLongFunction = (x) -> (long) x;
    System.out.println("x: " + doubleToLongFunction.applyAsLong(1));

    ToIntFunction<Integer> toIntFunction = (x) -> (int) x;
    System.out.println("x: " + toIntFunction.applyAsInt(1));

    ToIntBiFunction<Integer, Integer> toIntBiFunction = (x, y) -> (int) x + y;
    System.out.println("x: " + toIntBiFunction.applyAsInt(1, 2));

    ToLongFunction<Integer> toLongFunction = (x) -> (long) x;
    System.out.println("x: " + toLongFunction.applyAsLong(1));

    ToLongBiFunction<Integer, Integer> toLongBiFunction = (x, y) -> (long) x + y;
    System.out.println("x: " + toLongBiFunction.applyAsLong(1, 2));

    ToDoubleFunction<Integer> toDoubleFunction = (x) -> (double) x;
    System.out.println("x: " + toDoubleFunction.applyAsDouble(1));

    ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (x, y) -> (double) x + y;
    System.out.println("x: " + toDoubleBiFunction.applyAsDouble(1, 2));
    //endregion
  }

}
