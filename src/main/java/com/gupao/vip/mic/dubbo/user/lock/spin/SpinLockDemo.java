package com.gupao.vip.mic.dubbo.user.lock.spin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author fuguofeng
 */
public class SpinLockDemo {

    AtomicReference<Thread> lock = new AtomicReference<Thread>();

    public void lock(){
        while(!lock.compareAndSet(null, Thread.currentThread())){

        }
        System.out.println(Thread.currentThread().getId() + "\t lock invoked");
    }

    public void unlock(){
        lock.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getId() + "\t unlock invoked");
    }


    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo demo = new SpinLockDemo();
        new Thread(() -> {
            demo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                demo.unlock();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            demo.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                demo.unlock();
            }
        }).start();
    }

}
