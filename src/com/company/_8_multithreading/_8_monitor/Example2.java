package com.company._8_multithreading._8_monitor;

public class Example2 {

    static final Object lock = new Object();

    void mobile() {
        synchronized (lock) { // также можно использовать Example2.class
            try {
                System.out.println("mobile");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void whatsapp() {
        synchronized (lock) {
            try {
                System.out.println("whatsapp");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        var t1 = new Thread11();
        var t2 = new Thread12();

        t1.start();
        t2.start();


    }

}

class Thread11 extends Thread {

    @Override
    public void run() {
        new Example2().mobile();
    }

}

class Thread12 extends Thread {

    @Override
    public void run() {
        new Example2().whatsapp();
    }

}

