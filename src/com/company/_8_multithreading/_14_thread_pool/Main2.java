package com.company._8_multithreading._14_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
//        var s1 = Executors.newScheduledThreadPool(2);
//
//        s1.schedule(new Thread1(), 2, TimeUnit.SECONDS); // через 2 секунды начинает работать
//
//        s1.shutdown();

        var s1 = Executors.newScheduledThreadPool(2);

//        s1.scheduleAtFixedRate(new Thread1(), 2, 1, TimeUnit.SECONDS); // через 2 сек начинает работу и каждый 1 сек повторяет
        s1.scheduleWithFixedDelay(new Thread1(), 2, 1, TimeUnit.SECONDS); // через 2 сек начинает работу и каждый 1 сек промежуток от 1 и 2 повторяет

        Thread.sleep(10000);
        s1.shutdown();

        var s2 = Executors.newCachedThreadPool(); // если 1 занят создает новый, если освобился 1 поток и есть новая задача то использует 1
    }

}