package com.gupao.vip.mic.dubbo.user.vola;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    public static void main(String[] args) {
        VolatileTest.MyData myData = new VolatileTest.MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    //myData.addOne();
                    myData.addOneAtomic();
                }
            }).start();
        }

        new Thread(() -> {
            System.out.println(1);
        }).start();

        new Thread(() -> {
            System.out.println(1);
        }).run();

        while(Thread.activeCount() > 2){

        }
        System.out.println(myData.getAtomicInteger());

    }

    @Data
    static class MyData{
        private volatile int number = 0;
        private AtomicInteger atomicInteger = new AtomicInteger();

        public void addOneAtomic(){
            atomicInteger.getAndIncrement();
        }

        public void addOne(){
            number++;
        }
    }

}
