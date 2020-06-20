package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndConditionTest {

    public static void main(String[] args) {
        AirCondition condition = new AirCondition();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    condition.print(1, "A");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    condition.print(2, "B");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    condition.print(3, "C");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

class AirCondition{

    private volatile int number = 1;

    private int rotations = 0;

    private Lock lock = new ReentrantLock();

    private Condition print5Lock = lock.newCondition();
    private Condition print10Lock = lock.newCondition();
    private Condition print15Lock = lock.newCondition();

    /*public void print5() throws InterruptedException {
        lock.lock();*/
        /*try{
            while(number != 1){
                print5Lock.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
            }
            number = 2;
            print10Lock.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try{
            while(number != 2){
                print10Lock.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }
            number = 3;
            print15Lock.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try{
            while(number != 3){
                print15Lock.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("C");
            }
            number = 1;
            print5Lock.signalAll();
        }finally {
            lock.unlock();
        }
    }*/

    public void print(int number, String content) throws InterruptedException {
        lock.lock();
        this.rotations = this.number == 1 ? 5 : (this.number == 2 ? 10 : 15);
        try{
            while(this.number != number){
                if(number == 1){
                    print5Lock.await();
                }else if(number == 2){
                    print10Lock.await();
                }else{
                    print15Lock.await();
                }
            }
            for (int i = 0; i < this.rotations; i++) {
                System.out.println(content);
            }
            this.number = this.number == 1 ? 2 : (this.number == 2 ? 3 : 1);

            if(number == 1){
                print10Lock.signalAll();
            }else if(number == 2){
                print15Lock.signalAll();
            }else{
                print5Lock.signalAll();
            }

        }finally {
            lock.unlock();
        }
    }

}