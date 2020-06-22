package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(7, () -> {
            System.out.println("***");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
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
