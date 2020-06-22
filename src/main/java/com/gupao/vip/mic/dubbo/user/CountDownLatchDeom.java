package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDeom {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(111);
    }

}
