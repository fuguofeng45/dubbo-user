package com.gupao.vip.mic.dubbo.user.deadlock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或者两个以上的进程在执行过程中
 * 因争夺资源而造成的一种互相等待的现象
 * 若无外力干涉那他们都将无法推进下去
 * @author fuguofeng
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String l1 = "lock1";
        String l2 = "lock2";
        new Thread(new HoldLockThread(l1, l2)).start();
        new Thread(new HoldLockThread(l2, l1)).start();
    }

}

@AllArgsConstructor
@Data
class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public void setLockA(String lockA) {
        this.lockA = lockA;
    }

    public void setLockB(String lockB) {
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (this.lockA){
            System.out.println(Thread.currentThread().getId() + "\t获得锁\t" + this.lockA + "\t尝试获得锁\t" + this.lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (this.lockB){
                    System.out.println(Thread.currentThread().getId() + "\t获得锁\t" + this.lockB + "\t尝试获得锁\t" + this.lockA);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
