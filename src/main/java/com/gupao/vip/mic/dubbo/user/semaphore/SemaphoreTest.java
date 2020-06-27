package com.gupao.vip.mic.dubbo.user.semaphore;

import java.sql.Time;
import java.util.concurrent.*;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                3L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }
                });
            }
        } finally {
            executorService.shutdown();
        }
    }

}
