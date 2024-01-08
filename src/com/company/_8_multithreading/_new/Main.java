package com.company._8_multithreading._new;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

  public static final Object lock = new Object();

  public static void main(String[] args) {
    //region Варианты создания потоков
    /*{
      MyThread myThread = new MyThread();
      myThread.start();

      Thread myRunnable = new Thread(new MyRunnable());
      myRunnable.start();

      FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
      new Thread(futureTask).start();

      try {
        System.out.println(futureTask.get());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }*/
    //endregion

    //region Thread name и Thread priority
    /*{
      System.out.println("thread name: " + Thread.currentThread().getName() + ", thread priority: " + Thread.currentThread().getPriority());
    }*/
    //endregion

    //region Методы sleep и join. Thread states
    /*{
      InnerSleepThread myThread = new InnerSleepThread();

      System.out.println("tz3kr5JMHj :: thread start state: " + myThread.getState());

      myThread.start();

      for (int i = 0; i < 100; i++) {
        System.out.println("tz3kr5JMHj :: thread state: " + myThread.getState());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }*/
    //endregion

    //region data race
    /*{
      var sharedResources = new SharedResources();

      var lock = new Object();

      Thread thread1 = new Thread(() -> {
        for (int i = 0; i < 100_000; i++) {
          System.out.println("1");
          sharedResources.increment();
        }
      });

      Thread thread2 = new Thread(() -> {
        for (int i = 0; i < 100_000; i++) {
          System.out.println("2");
          sharedResources.increment();
        }
      });

      thread1.start();
      thread2.start();

      try {
        thread1.join();
        thread2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("7VJq1m58EO :: sharedResources: " + sharedResources.getCounter());
    }*/
    //endregion



    //region wait & notify
    {

      var sharedResources = new SharedResources();

      AtomicBoolean messageReceived = new AtomicBoolean(true);

      Thread supplier = new Thread(() -> {
        while (sharedResources.counter < 100_000) {
          synchronized (lock) {
            System.out.println("uvH8qTMHLp :: 1");
            while (messageReceived.get()) {
              try {
                lock.wait();
                System.out.println("3");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }

            sharedResources.increment();
            messageReceived.set(false);
            lock.notifyAll();
          }
        }
      });

      var consumer = new Thread(() -> {
        while (sharedResources.counter < 100_000) {
          synchronized (lock) {
            System.out.println("uvH8qTMHLp :: 2");

            while (messageReceived.get()) {
              try {
                lock.wait();
                System.out.println("3");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }

            System.out.println(sharedResources.getCounter());
            messageReceived.set(true);
            lock.notifyAll();
          }
        }
      });

      supplier.start();
      consumer.start();

      try {
        supplier.join();
        consumer.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("4n17vPo8ML :: counter :: " + sharedResources.getCounter());
    }
    //endregion
  }

  static class SharedResources {
    private int counter = 0;

    public void increment() {
      counter++;
    }

    public int getCounter() {
      return counter;
    }
  }

  static class SynchronizedSharedResources {
    private int counter = 0;

    public synchronized void increment() {
      counter++;
    }

    public int getCounter() {
      return counter;
    }
  }

  static class InnerSleepThread extends Thread {

    @Override
    public void run() {
      var sleepThread = new SleepThread();
      sleepThread.start();

      sleepThread.interrupt();

      try {
        sleepThread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      for (int i = 0; i < 10; i++) {
        try {
          System.out.println("IpC3I04677 :: InnerSleepThread state: " + sleepThread.getState());
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  }

  static class SleepThread extends Thread {

    @Override
    public void run() {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("jAvPa13A5u :: sleep thread finished");
    }

  }

  static class MyThread extends Thread {

    @Override
    public void run() {
      System.out.println("Hello from MyThread");
    }

  }

  static class MyRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println("Hello from MyRunnable");
    }

  }

  static class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
      return "Hello from MyCallable";
    }

  }

}
