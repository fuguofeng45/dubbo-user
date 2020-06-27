package com.gupao.vip.mic.dubbo.user.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fuguofeng
 */
public class SpinLock {

    AtomicReference<Thread> spinLock = new AtomicReference<Thread>();

    public void lock(){
        while(!spinLock.compareAndSet(null, Thread.currentThread())){

        }
    }

    public void unlock(){
        spinLock.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {

    }

}
