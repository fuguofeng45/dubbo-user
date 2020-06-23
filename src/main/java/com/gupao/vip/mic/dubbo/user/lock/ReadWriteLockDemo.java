package com.gupao.vip.mic.dubbo.user.lock;

import com.gupao.vip.mic.dubbo.user.SemaphoreTest2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 如果有一个线程想去写共享资源类，就不应该再有其他线程可以对资源进行读或者写
 *
 * 小总结：
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock(true);

        ReadWriteLockDemo.MyCache myCache = new ReadWriteLockDemo.MyCache();

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

        /**
         * 读写锁
         */
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        private volatile Map<String, Object> map = new HashMap<>();

        public void put(String key, Object value) {
            readWriteLock.writeLock().lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t开始写入");
                this.map.put(key, value);
                System.out.println(Thread.currentThread().getName() + "\t写入成功");
            }finally {
                readWriteLock.writeLock().unlock();
            }

        }

        public void get(String key) {
            readWriteLock.readLock().lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t开始读取");
                Object object = this.map.get(key);
                System.out.println(Thread.currentThread().getName() + "\t读取成功" + object);
            }finally {
                readWriteLock.readLock().unlock();
            }
        }

    }

}

