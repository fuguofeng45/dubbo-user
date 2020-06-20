package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumerDemo {

    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
        NewAircondition newAircondition = new NewAircondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    newAircondition.decrement();
                } catch (Exception e) {
                }
            }
        }, "A-thread").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    newAircondition.increment();
                } catch (Exception e) {
                }
            }
        }, "B-thread").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    newAircondition.decrement();
                } catch (Exception e) {
                }
            }
        }, "C-thread").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    newAircondition.increment();
                } catch (Exception e) {
                }
            }
        }, "D-thread").start();
    }

}

class Aircondition {

    private volatile int number = 0;

    public synchronized void increment() throws Exception {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " increment ==> " + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + " decrement ==> " + number);
        this.notifyAll();
    }

}

class NewAircondition{

    private volatile int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            while (number != 0) {
                //this.wait(); wait notify 必须与sync一起使用
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " increment ==> " + number);
            //this.notifyAll(); lock必须与Condition
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try{
            while (number == 0) {
                //this.wait(); wait notify 必须与sync一起使用
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " decrement ==> " + number);
            //this.notifyAll();
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
