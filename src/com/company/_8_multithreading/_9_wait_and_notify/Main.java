package com.company._8_multithreading._9_wait_and_notify;

public class Main {

    public static void main(String[] args) {
        var market = new Market();

        var t1 = new Thread(new Thread1(market));
        var t2 = new Thread(new Thread2(market));

        t1.start();
        t2.start();
    }

}

class Market {

    int breadCount = 0;

    public synchronized void putBread() {

        while (breadCount >= 5) {

            try {
                wait(); // wait(2000) также как join, эти методы работают на this
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        breadCount++;
        System.out.println("new bread added, bread count - " + breadCount);
        notify();
    }

    public synchronized void getBread() {

        while (breadCount < 1) {

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        breadCount--;
        System.out.println("new bread get, bread count - " + breadCount);
        notify();
    }

}

class Thread1 implements Runnable {

    Market market;

    public Thread1(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

class Thread2 implements Runnable {

    Market market;

    public Thread2(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}
