package com.company._8_multithreading._15_callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static int result;

    public static void main(String[] args) {

        var e = Executors.newSingleThreadExecutor();
        var t = new Thread1();
        Future<Integer> f = e.submit(t);

        try {
            System.out.println("1");
            result = f.get();
            System.out.println("2 - ");
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        } finally {
            e.shutdown();
        }

        System.out.println(result);
    }

}

class Thread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 1;
    }

}
