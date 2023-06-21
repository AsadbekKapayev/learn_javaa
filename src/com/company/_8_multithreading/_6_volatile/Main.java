package com.company._8_multithreading._6_volatile;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread1();

        t1.start();

        Thread.sleep(3000);

        t1.isRun = false;

        System.out.println("finished");
    }

}

class Thread1 extends Thread {

    volatile boolean isRun = true; // если не использовать volatile тогда значение будет кешироваться

    @Override
    public void run() {
        int counter = 0;

        while (isRun) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            counter++;
        }

        System.out.println("name: " + Thread.currentThread().getName());
    }

}
