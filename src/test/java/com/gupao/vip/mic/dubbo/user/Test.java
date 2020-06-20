package com.gupao.vip.mic.dubbo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        new Thread(() -> {
            try {
                student.f2();
            } catch (InterruptedException e) {
            }
        }, "1").start();
        new Thread(() -> {
            student.f1();
        }, "2").start();
    }

}

class Student{

    public synchronized void f1(){
        System.out.println("f1");
    }

    public synchronized void f2() throws InterruptedException {
        System.out.println("f2");
    }

}
