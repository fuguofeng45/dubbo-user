package com.gupao.vip.mic.dubbo.user.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        /*System.out.println(queue.add("1"));
        System.out.println(queue.add("2"));
        System.out.println(queue.add("3"));

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());*/
       /* System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue.offer("3"));
        System.out.println(queue.offer("3"));*/
        queue.put("1");
        queue.put("1");
        queue.put("1");
        queue.put("1");
    }

}
