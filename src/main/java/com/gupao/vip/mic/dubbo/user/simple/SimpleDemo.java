package com.gupao.vip.mic.dubbo.user.simple;

public class SimpleDemo {

    private static volatile SimpleDemo simpleDemo = null;

    private SimpleDemo(){
        System.out.println(Thread.currentThread().getName());
    }

    public static SimpleDemo getInstance(){
        if(simpleDemo == null){
            synchronized (SimpleDemo.class){
                if(simpleDemo == null){
                    simpleDemo = new SimpleDemo();
                }
            }
        }
        return simpleDemo;
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
