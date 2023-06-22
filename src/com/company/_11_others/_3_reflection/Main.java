package com.company._11_others._3_reflection;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        var user = User.class;

//        var field = user.getField("id");
//        var fields = user.getFields();
//
//        for (var field : fields) {
//            System.out.println("name: " + field.getName() + ", type: " + field.getType());
//        }

        var allFields = user.getDeclaredFields();

        for (var field : allFields) {
            System.out.println("name: " + field.getName() + ", type: " + field.getType());
        }

        System.out.println("----------");

        var method = user.getMethod("method1");

        System.out.println("name: " + method.getName() + ", type: " + method.getReturnType());


    }

}

class User {
    private Long id;
    public String name;

    public void method1() {
        System.out.println("I am 1");
    }

    private void method2() {
        System.out.println("I am 2");
    }

}
