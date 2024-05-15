package grade_1._1_common_stack;

public class Main {

  public static void main(String[] args) {
  }

  //region <1> Singleton Eager Initialization
  static class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
      return instance;
    }
  }
  //endregion

  //region <2> Singleton Lazy Initialization
  static public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
      if (instance == null) {
        instance = new Singleton2();
      }
      return instance;
    }
  }
  //endregion

}
