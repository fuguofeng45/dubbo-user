package com.gupao.vip.mic.dubbo.user.completable;

import java.util.concurrent.CompletableFuture;

/**
 * @author fuguofeng
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 1024;
        });
    }

}
