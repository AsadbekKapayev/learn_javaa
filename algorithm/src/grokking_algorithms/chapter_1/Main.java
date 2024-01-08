package grokking_algorithms.chapter_1;

import util.RND;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    //region binary search
    /*{
      var strings = IntStream.range(0, 8)
              .mapToObj(x -> RND.strEng(11))
              .sorted()
              .collect(Collectors.toList());

      var searchText = strings.get(2);

      System.out.println("all strings :: " + strings);
      System.out.println("search text: " + searchText + ", result: " + binarySearch(searchText, strings));
    }*/
    //endregion

    //region selection sort 1
    /*{
      var ints = IntStream.range(0, 100).toArray();

      for (int i = 0; i < ints.length; i++) {
        var smaller = 0;

        for (int j = i; j < ints.length; j++) {

          if (ints[i] > ints[j]) {
            smaller = ints[i];
            ints[i] = ints[j];
            ints[j] = smaller;
          }

        }

      }

      System.out.println("ints array: " + Arrays.toString(ints));
    }*/
    //endregion

    //region selection sort 2
    /*{
      var ints = IntStream.range(0, 100).toArray();
      var result = new ArrayList<Integer>();

      for (int i = 0; i < ints.length; i++) {
        var highest = ints[i];
        var highestIndex = i;

        for (int j = 0; j < ints.length; j++) {

          if (highest < ints[j]) {
            highest = ints[j];
            highestIndex = j;
          }

        }

        result.add(highest);
        ints[highestIndex] = -1;
      }

      System.out.println("result :: " + result);
    }*/
    //endregion

    //region countdown, factorial
    {
      countdown(10);

      System.out.println("\n\nfactorial: " + factorial(4));
    }
    //endregion

    //region chef ex
    {
      var values = new ArrayDeque<String>();

      for (int i = 0; i < 100; i++) {
        values.add(RND.strEng(11));
      }

      while (values.peek() != null) {
        System.out.println(values.pop());
      }

    }
    //endregion

    //region fibonacci
    {
      System.out.println("IZiEC3RhK1 :: fibonacci: " + fibonacci(10));
    }
    //endregion

    //region
    {
      System.out.println(quicksort(List.of(3, 5, 1, 2, 6, 8, 3)));
    }
    //endregion

  }

  public static List<Integer> quicksort(List<Integer> array) {

    if (array.size() < 2) {
      return array;
    }

    var op = array.get(0);
    var intLeft = new ArrayList<Integer>();
    var intRight = new ArrayList<Integer>();

    for (int i = 1; i < array.size(); i++) {
      if (op >= array.get(i)) {
        intLeft.add(array.get(i));
        continue;
      }

      intRight.add(array.get(i));
    }

    return Stream.concat(Stream.concat(intLeft.stream(), Stream.of(op)), intRight.stream())
            .collect(Collectors.toList());
  }

  public static int fibonacci(int i) {

    if (i < 3) {
      return 1;
    }

    return fibonacci(i - 1) + fibonacci(i - 2);
  }

  public static int factorial(int i) {

    if (i == 0) {
      return 1;
    }

    return i * factorial(i - 1);
  }

  public static void countdown(int i) {
    if (i > 0) {
      countdown(i - 1);
    }

    System.out.println("i: " + i);
  }

  public static String binarySearch(String search, List<String> strings) {
    int mid;
    int low = 0;
    int high = strings.size() - 1;
    int step = 0;

    while (low <= high) {
      mid = (low + high) / 2;
      var compare = Objects.compare(search, strings.get(mid), String::compareTo);

      System.out.println("step: " + ++step);

      if (compare > 0) {
        low = mid + 1;
      } else if (compare < 0) {
        high = mid - 1;
      } else {
        return strings.get(mid);
      }
    }

    return null;
  }

}
