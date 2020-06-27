package com.gupao.vip.mic.dubbo.user.simple.dcl;

import com.gupao.vip.mic.dubbo.user.simple.SimpleDemo;

/**
 * @author fuguofeng
 */
public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    SimpleDemo.getInstance();
                }
            }).start();
        }
    }

}
