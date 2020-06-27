package com.gupao.vip.mic.dubbo.user.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author fuguofeng
 */
public class AtomicReferenceStampDemo {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5, 2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
        System.out.println("===========ABA===========");
        executorService.execute(new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(100, 101));
            System.out.println(atomicReference.compareAndSet(101, 100));
        }));
        executorService.execute(new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(atomicReference.compareAndSet(100, 2019));
                System.out.println(atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.shutdown();
        System.out.println("===========ABA 解决===========");


        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    }

}
