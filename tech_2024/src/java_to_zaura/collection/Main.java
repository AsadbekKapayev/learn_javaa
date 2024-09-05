package java_to_zaura.collection;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    iterable();
  }

  // region Operator - Bit operations & |
  public static void operator() {
    int a = 11; // 1011
    int b = 5;  // 0101

    System.out.println(a & b); // 0001 - 1
    System.out.println(a | b); // 1111 - 15
    System.out.println(a ^ b); // 1110 - 14
    System.out.println(~a); // 1111 1111 1111 1100 - -12
    System.out.println(a << 1); // 0001 0110 - 31
    System.out.println(a >> 1); // 0101 - 5
    System.out.println(a >>> 1); // 0101 - 5
  }
  // endregion Operator - Bit operations & |

  // region Spliterator
  public static void spliterator() {
    var integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    var spliterator = integers.spliterator();

    var spliterator2 = spliterator.trySplit();

    spliterator.forEachRemaining(System.out::println);
    spliterator2.forEachRemaining(System.out::println);
  }
  // endregion Spliterator

  // region Iterable
  public static void iterable() {
    var integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    var iterator = integers.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  // endregion Iterable

  // region List
  public static void list() {
    {
      var integers = new ArrayList<Integer>();
    }
    {
      var integers = new LinkedList<Integer>();
    }
    {
      var integers = new Vector<Integer>();
    }
    {
      var integers = new Stack<Integer>();
      integers.push(1);
      integers.pop();
      integers.peek();
    }
  }
  // endregion List

  // region Queue
  public static void queue() {
    {
      var integers = new ArrayDeque<Integer>();
    }
    {
      var integers = new PriorityQueue<Integer>();
    }
  }
  // endregion Queue

  // region Map
  public static void map() {
    {
      var integerIntegerHashtable = new Hashtable<Integer, Integer>();
    }
    {
      var hashMap = new HashMap<String, String>();
    }
    {
      var linkedHashMap = new LinkedHashMap<String, String>();
    }
    {
      var stringStringTreeMap = new TreeMap<String, String>();
    }
    {
      var stringStringWeakHashMap = new WeakHashMap<String, String>();
    }
  }
  // endregion Map

  // region Tree
  public static void tree() {
    {
      var strings = new HashSet<String>();
    }
    {
      var strings = new LinkedHashSet<String>();
    }
    {
      var strings = new TreeSet<String>();
    }
  }
  // endregion Tree

}
