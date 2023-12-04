package com.company._7_streams._new;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = List.of(1, 2, 3);

    //region Stream obj
    Stream<Integer> stream = list.stream();
    //endregion

    //region filter && forEach
    list.stream().filter(x -> x > 0).forEach(System.out::println);
    //endregion

    //region reduce
    var reduce1 = list.stream().reduce(Integer::sum).orElseThrow();
    var reduce2 = list.stream().reduce(1, Integer::sum);
    var reduce3 = list.stream().reduce(1, Integer::sum, Integer::sum);
    var reduce4 = list.parallelStream().reduce(1, Integer::sum, Integer::sum);

    System.out.println("reduce 1 :: " + reduce1);
    System.out.println("reduce 2 :: " + reduce2);
    System.out.println("reduce 3 :: " + reduce3);
    System.out.println("reduce 4 :: " + reduce4);
    //endregion

    //region sorted
    list.stream().sorted().forEach(System.out::println);
    list.stream().sorted(Comparator.comparing((y) -> y)).forEach(System.out::println);
    //endregion

    //region concat
    var newStream = Stream.concat(list.stream(), list.stream());
    //endregion

    //region distinct
    var distinct = list.stream().distinct().collect(Collectors.toList());
    //endregion

    //region count
    var count = list.stream().count();
    //endregion

    //region peek
    var peek = list.stream().peek(System.out::println).collect(Collectors.toList());
    //endregion

    //region flatMap
    var flatMap = Stream.of(List.of(1, 2), List.of(1, 2)).flatMap(Collection::stream).collect(Collectors.toList());
    var flatMapToInt = Stream.of(List.of(1, 2), List.of(1, 2)).flatMapToInt(x -> x.stream().mapToInt(y -> y));
    //endregion

    //region collect, grouping & partitioning
    var people = List.of(new Person("John", 16), new Person("Sam", 16), new Person("July", 17));

    var peopleGroping = people.stream().collect(Collectors.groupingBy(x -> x.age));
    System.out.println(peopleGroping);

    var peoplePartitioning = people.stream().collect(Collectors.partitioningBy(x -> x.age > 16));
    System.out.println(peoplePartitioning);
    //endregion

    //region findFirst, FindAny
    var findFirst = list.stream().findFirst().orElseThrow();
    var findAny = list.stream().findAny().orElseThrow();

    System.out.println("findFirst: " + findFirst);
    System.out.println("findAny: " + findAny);
    //endregion

    //region min & max
    var min = list.stream().min(Comparator.comparing((x) -> x)).orElseThrow();
    var max = list.stream().max(Comparator.comparing((x) -> x)).orElseThrow();
    //endregion

    //region limit & skip
    var limit = list.stream().limit(1).collect(Collectors.toList());
    var skip = list.stream().skip(1).collect(Collectors.toList());

    System.out.println("limit: " + limit);
    System.out.println("skip: " + skip);
    //endregion

    //region mapToInt
    var intStream = list.stream().mapToInt(x -> x);
    //endregion
  }

  static class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", age=" + age +
              '}';
    }
  }

}
