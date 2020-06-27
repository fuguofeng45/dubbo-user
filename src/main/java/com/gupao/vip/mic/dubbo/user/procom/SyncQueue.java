package com.gupao.vip.mic.dubbo.user.procom;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuguofeng
 */
public class SyncQueue {

    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new SynchronousQueue());

        new Thread(() -> {
            try {
                myResource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consume").start();

        new Thread(() -> {
            try {
                myResource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product").start();

        TimeUnit.SECONDS.sleep(1);

        myResource.stop();
        System.out.println("取消生产完毕");
    }

}

class MyResource {

    /**
     * 默认开启，进行生产+消费
     */
    private volatile boolean flag = true;
    private AtomicInteger number = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue queue) {
        System.out.println(queue.getClass().getName());
        this.blockingQueue = queue;
    }

    /**
     * 消费者方法
     *
     * @throws InterruptedException
     */
    public void consume() throws InterruptedException {
        String result = null;
        while (flag) {
            result = this.blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                System.out.println("消费者获取消息超时");
                return;
            }
            System.out.println(Thread.currentThread().getId() + "\t获取消息为：" + result);
        }
        System.out.println("取消消费");
    }

    /**
     * 生产者方法
     *
     * @throws InterruptedException
     */
    public void produce() throws InterruptedException {
        String data = null;
        while (flag) {
            data = number.getAndIncrement() + "";
            if (this.blockingQueue.offer(data, 2L, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getId() + "\t生产成功\t" + number);
            }
        }
        System.out.println("取消生产");
    }

    /**
     * 修改生产标志位，取消生产消费
     */
    public void stop(){
        this.flag = false;
    }

}