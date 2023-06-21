package com.company._8_multithreading._12_deamon;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread1();
        var d1 = new DaemonThread();

        d1.setDaemon(true);

        d1.start();
        t1.start();

        System.out.println("End");
    }

}

class DaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("is daemon: " + isDaemon() + ", i: " + i);
        }
    }

}

class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("is daemon: " + isDaemon() + ", i: " + i);
        }
    }

}
