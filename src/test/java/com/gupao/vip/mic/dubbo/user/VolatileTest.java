package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    public static void main(String[] args) {
        Data data = new Data();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.addPlusPlus();
                }
            }).start();
        }
        // 默认有 main 线程和 gc 线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(data.count);
    }

}

class Data{

    AtomicInteger atomicInteger = new AtomicInteger();

    volatile int count;

    public void addTo60(){
        this.count = 60;
    }

    public void addPlusPlus(){
            this.count++;
    }

}
