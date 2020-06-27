package com.gupao.vip.mic.dubbo.user.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo2 {

    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void lock() {
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {

        }
    }

    public void unlock() {
        atomicReference.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory() / (double) 1024 / 1024);
        System.out.println(Runtime.getRuntime().maxMemory() / (double) 1024 / 1024);
    }


}
