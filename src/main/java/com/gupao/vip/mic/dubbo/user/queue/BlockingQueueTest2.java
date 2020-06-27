package com.gupao.vip.mic.dubbo.user.queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author fuguofeng
 */
public class BlockingQueueTest2 {

    public static void main(String[] args) throws InterruptedException {
        blockDemo();

        initLinkQueue();

        return;
    }

    private static void initLinkQueue() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    }

    private static void blockDemo() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(4);
        blockingQueue.offer("123", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("123", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("123", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("123", 2L, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){

    }

}
