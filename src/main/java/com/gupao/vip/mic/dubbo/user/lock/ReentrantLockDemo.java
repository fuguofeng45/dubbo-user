package com.gupao.vip.mic.dubbo.user.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（递归锁）
 * @author fuguofeng
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
       /* new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();*/

        System.out.println("=======================");


        Thread thread1 = new Thread(phone);
        Thread thread2 = new Thread(phone);
        thread1.start();
        thread2.start();
    }

}

class Phone implements Runnable{

    private Lock lock = new ReentrantLock();

    public synchronized void sendSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getId()+ "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getId()+ "\t invoked sendEmail()");
    }

    @Override
    public void run() {
        get();
    }

    private void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoked get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId() + "\t invoked set()");
        }finally {
            lock.unlock();
        }
    }

}
