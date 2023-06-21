package com.company._8_multithreading._13_interrupt;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread1();

        t1.start();

        Thread.sleep(3000);

        t1.interrupt();

        System.out.println("end - " + t1.isInterrupted());

    }

}

class Thread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10000000; i++) {

            System.out.println("is interrupted - " + isInterrupted() + ", i - " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException - " + isInterrupted());
                throw new RuntimeException(e);
            }

        }


    }

}