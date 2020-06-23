package com.gupao.vip.mic.dubbo.user.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo1 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);
        arrayBlockingQueue.offer(1, 3L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(2, 3L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(3, 3L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(4, 3L, TimeUnit.SECONDS);
        arrayBlockingQueue.offer(5, 3L, TimeUnit.SECONDS);

        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));

        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.offer(5, 3L, TimeUnit.SECONDS);
        linkedBlockingQueue.offer(4, 3L, TimeUnit.SECONDS);
        linkedBlockingQueue.offer(3, 3L, TimeUnit.SECONDS);
        linkedBlockingQueue.offer(2, 3L, TimeUnit.SECONDS);

        System.out.println(linkedBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(linkedBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(linkedBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(linkedBlockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(linkedBlockingQueue.poll(2L, TimeUnit.SECONDS));
    }

}
