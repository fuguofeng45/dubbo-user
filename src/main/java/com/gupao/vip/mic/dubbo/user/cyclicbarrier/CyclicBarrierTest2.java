package com.gupao.vip.mic.dubbo.user.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest2 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, () -> {
            System.out.println(1);
        });
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
