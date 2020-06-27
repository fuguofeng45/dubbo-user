package com.gupao.vip.mic.dubbo.user.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo3 {

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
           return "";
        });
        completableFuture.whenComplete((t, u) -> {
            System.out.println("123" + t);
            System.out.println(u);
        }).exceptionally((t) -> {
            return "";
        });
    }

}
