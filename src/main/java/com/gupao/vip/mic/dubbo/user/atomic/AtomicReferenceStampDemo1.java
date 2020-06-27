package com.gupao.vip.mic.dubbo.user.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceStampDemo1 {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100, 1);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(atomicStampedReference.compareAndSet(
                        100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
                System.out.println(atomicStampedReference.compareAndSet(
                        101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            int timeStamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println( atomicStampedReference.compareAndSet(
                        100, 2020, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
                System.out.println(atomicStampedReference.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }

}
