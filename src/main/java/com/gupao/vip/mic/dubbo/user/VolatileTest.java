package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                myNumber.addTo1025();
            } catch (InterruptedException e) {
            }
        }).start();
        while (myNumber.number == 10){

        }
        System.out.println(1);
    }

}

class MyNumber{

    volatile int number = 10;

    public void addTo1025(){
        number = 1025;
    }

}
