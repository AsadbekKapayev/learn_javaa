package com.company._8_multithreading._3_name_and_priority;

public class Main extends Thread {

    public static void main(String[] args) {
        var t1 = new Thread1();
        var t2 = new Thread(new Thread2());

        t1.start();
        t2.start();
    }

}


class Thread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread 1 :: name :: " + Thread.currentThread().getName() + ", priority :: " + Thread.currentThread().getPriority() + ", value :: " + i);
        }

    }

}

class Thread2 implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread 2 :: name :: " + Thread.currentThread().getName() + ", priority :: " + Thread.currentThread().getPriority() + ", value :: " + i);
        }

    }

}
