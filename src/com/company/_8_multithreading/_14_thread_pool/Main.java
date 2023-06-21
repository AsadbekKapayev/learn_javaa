package com.company._8_multithreading._14_thread_pool;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        var tp = Executors.newFixedThreadPool(5);
        var tp = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {

            tp.execute(new Thread1());

        }

        tp.shutdown();
//        tp.awaitTermination(1000, TimeUnit.MILLISECONDS);


        System.out.println("end");

    }

}

class Thread1 extends Thread {

    @Override
    public void run() {
        try {
            sleep(500);

            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}