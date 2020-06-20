package com.gupao.vip.mic.dubbo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo1 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (ticket.number > 0){
                    ticket.sale();
                }
            }).start();
        }

    }

}

class Ticket {

    public volatile int number = 1000;

    Lock lock = new ReentrantLock();//可重入锁

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + number-- + "\t还剩下：" + number);
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

}
