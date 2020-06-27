package com.gupao.vip.mic.dubbo.user.thread;

public class Thread01 implements Runnable{
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();
        new Mythread().start();
    }

}

class Mythread extends Thread{

    @Override
    public void run(){}

}

