package com.company._8_multithreading._16_semaphore;

import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        var s = new Semaphore(3);

        var t1 = new Thread1("u1", s);
        var t2 = new Thread1("u2", s);
        var t3 = new Thread1("u3", s);
        var t4 = new Thread1("u4", s);
        var t5 = new Thread1("u5", s);
        var t6 = new Thread1("u6", s);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

//        Collections.syn
    }

}

class Thread1 extends Thread {
    String name;
    Semaphore semaphore;

    public Thread1(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(name + "использут " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(name + "завершил" + Thread.currentThread().getName());
            semaphore.release();
        }

    }

}
