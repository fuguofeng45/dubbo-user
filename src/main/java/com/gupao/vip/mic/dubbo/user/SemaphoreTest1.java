package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest1 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t获取资源");
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "\t释放资源");
                }
            }).start();
        }
    }

}
