package com.gupao.vip.mic.dubbo.user.procom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tradition {

    public static void main(String[] args) {

        MyData myData = new MyData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //myData.increment();
                    myData.incrementByLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"increment").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //myData.decrement();
                    myData.decrementByLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"decrement").start();
    }

}

class MyData{

    private volatile int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    public synchronized void increment() throws InterruptedException {

        while(number != 0){
            this.wait();
        }

        number++;
        System.out.println(Thread.currentThread().getId() + "\t increment \t" + number);
        this.notifyAll();

    }

    public synchronized void decrement() throws InterruptedException {

        while(number == 0){
            this.wait();
        }

        number--;
        System.out.println(Thread.currentThread().getId() + "\t decrement \t" + number);
        this.notifyAll();

    }

    public void incrementByLock(){
        lock.lock();
        try{
            while(number != 0){
                condition1.await();
            }

            number++;
            System.out.println(Thread.currentThread().getId() + "\t increment \t" + number);
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void decrementByLock(){
        lock.lock();
        try{
            while(number == 0){
                condition1.await();
            }

            number--;
            System.out.println(Thread.currentThread().getId() + "\t increment \t" + number);
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}



