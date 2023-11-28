package com.company._8_multithreading._15_callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static int result;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var e = Executors.newFixedThreadPool(5);
        var t = new Thread1();
        List<Future<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Hey");
            ret.add(e.submit(t));
        }

        Thread.sleep(10000);

        System.out.println(e);

        for (Future<Integer> future : ret) {
            future.get();
        }

        System.out.println("finish");
    }

}

class Thread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        return 1;
    }

}
