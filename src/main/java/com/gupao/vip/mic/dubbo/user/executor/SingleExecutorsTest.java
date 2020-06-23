package com.gupao.vip.mic.dubbo.user.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleExecutorsTest {

    public static void main(String[] args) {
        /**
         * 创建只有一个线程的线程池
         */
        ExecutorService pool = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 10; i++) {
                pool.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            pool.shutdown();
        }
    }

}
