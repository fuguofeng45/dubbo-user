package com.gupao.vip.mic.dubbo.user;

import java.util.HashMap;
import java.util.Map;

public class SemaphoreTest2 {

    public static void main(String[] args) {

        SemaphoreTest2.MyCache myCache = new SemaphoreTest2.MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(String.valueOf(tempInt), tempInt);
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tempInt));
            }).start();
        }

    }

    static class MyCache {

        private volatile Map<String, Object> map = new HashMap<>();

        public void put(String key, Object value) {
            System.out.println(Thread.currentThread().getName() + "\t开始写入");
            this.map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入成功");
        }

        public void get(String key) {
            System.out.println(Thread.currentThread().getName() + "\t开始读取");
            Object object = this.map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取成功" + object);
        }

    }

}
