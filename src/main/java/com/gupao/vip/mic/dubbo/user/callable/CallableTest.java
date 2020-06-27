package com.gupao.vip.mic.dubbo.user.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "123";
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
