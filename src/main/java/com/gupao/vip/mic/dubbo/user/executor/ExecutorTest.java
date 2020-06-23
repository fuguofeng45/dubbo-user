package com.gupao.vip.mic.dubbo.user.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args) {
        /**
         * 创建一个线程池，有五个线程（固定数量的线程池 执行固定任务，性能好，有固定的线程有固定的线程数）
         */
        ExecutorService pool = Executors.newFixedThreadPool(5);
        /**
         * 模拟十个线程，池子里有五个线程
         */
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
