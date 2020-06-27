package com.gupao.vip.mic.dubbo.user.callable;

import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(123);
            return "";
        });
        new Thread(futureTask).start();
    }

}
