package com.gupao.vip.mic.dubbo.user.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    @Data
    @AllArgsConstructor
    @Accessors(chain = true)
    class User{
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        AtomicReferenceDemo demo = new AtomicReferenceDemo();
        User z3 = demo.new User("zhangsan", 21);
        User li4 = demo.new User("lisi", 25);
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();

        userAtomicReference.set(z3);
        System.out.println(userAtomicReference.compareAndSet(z3, li4));
        System.out.println(userAtomicReference.compareAndSet(z3, li4));
    }

}


