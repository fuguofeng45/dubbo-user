package com.gupao.vip.mic.dubbo.user.executor;

import java.util.concurrent.*;

public class ExecutorTest1 {

    /**
     * 阿里规范 自定义线程池
     *
     * @param args
     */
    public static void main(String[] args) {
        /*ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            executorService.shutdown();
        }*/
        System.out.println(Runtime.getRuntime().maxMemory() / (double) 1024 / 1024);
        System.out.println(Runtime.getRuntime().totalMemory() / (double) 1024 / 1024);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
