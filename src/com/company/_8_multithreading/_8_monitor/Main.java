package com.company._8_multithreading._8_monitor;

public class Main {

    public static int counter = 0;

    public static void inc() { // sync используется чтобы только 1 поток работал с этим методом
        synchronized (Main.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var v1 = new Thread1();
        var v2 = new Thread1();

        v1.start();
        v2.start();

        v1.join();
        v2.join();

        System.out.println(counter);
    }

}

class Thread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            Main.inc();
        }

    }

}


