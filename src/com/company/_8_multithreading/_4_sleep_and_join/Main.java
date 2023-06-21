package com.company._8_multithreading._4_sleep_and_join;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        var t1 = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                System.out.println("name: " + Thread.currentThread().getName() + ", value: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        System.out.println(t1.getState()); // NEW

        t1.start();

        System.out.println(t1.getState()); // RUNNABLE

        //        t1.join();
        t1.join(2000); // если за 2 сек поток не закончить работу тогда поток будет дальше работать

        System.out.println(t1.getState()); // TIMED_WAITING

        System.out.println("End");

        Thread.sleep(4000);

        System.out.println(t1.getState()); // TERMINATED

    }

}
