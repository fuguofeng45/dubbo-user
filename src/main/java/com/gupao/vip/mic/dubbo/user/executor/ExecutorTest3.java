package com.gupao.vip.mic.dubbo.user.executor;

import java.util.concurrent.*;

public class ExecutorTest3 {

    /**
     * 阿里巴巴规范规定，不允许用Executors创建线程池
     * 创建固定数量的线程池
     *
     * @return
     */
    public ExecutorService initFixedExecutorPool() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }

    /**
     * 创建只有一个线程的单一线程池
     *
     * @return
     */
    public ExecutorService initSingleExecutorPool() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 创建可扩展数量的线程池
     *
     * @return
     */
    public ExecutorService initCachedExecutorPool() {
        return Executors.newCachedThreadPool();
    }

    public ExecutorService initDefinedExecutorPool() {
        return new ThreadPoolExecutor(2, 5, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
