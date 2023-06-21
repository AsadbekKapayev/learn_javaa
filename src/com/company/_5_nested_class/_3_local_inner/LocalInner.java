package com.company._5_nested_class._3_local_inner;

public class LocalInner {

    public static void main(String[] args) {
        var math = new Math();

        math.getResult(3);
    }

}

class Math {
    private int a = 0;

    public void getResult(int b) {
//        int b = 3;

        class D {
            private int a;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getResult() {
                return a / b;
            }
        }

        var d = new D();
        d.setA(4);

        System.out.println(d.getResult());
        System.out.println("private outer element :: " + a);
    }
}
