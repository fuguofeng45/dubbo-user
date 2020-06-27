package com.gupao.vip.mic.dubbo.user.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author fuguofeng
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 没有返回值
         */
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 没有返回，update mysql ok");
        });

        /**
         * 异步回调 有返回值
         */
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 没有返回，insert mysql ok");
            //return 10 / 0;
            return 1024;
        }).whenComplete((t, u) -> {
            System.out.println("***t" + t);
            System.out.println("***u" + u);
        }).exceptionally((t) -> {
            System.out.println("***ex" + t.getMessage());
            return 500;
        });
    }

}
