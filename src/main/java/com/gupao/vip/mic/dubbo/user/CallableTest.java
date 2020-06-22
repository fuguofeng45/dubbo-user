package com.gupao.vip.mic.dubbo.user;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(111);
            return null;
        });
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        futureTask.get();
    }

}
