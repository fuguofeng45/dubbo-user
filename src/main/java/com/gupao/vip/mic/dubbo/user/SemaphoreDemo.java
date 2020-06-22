package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        /**
         * 模拟资源类 有三个空车位
         */
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    /**
                     * acquire（获取）当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1）
                     * 要么一直等下去，直到有线程释放信号量，或超时；
                     */
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢占到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t释放车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    /**
                     * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程
                     * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数量的控制
                     */
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

}
