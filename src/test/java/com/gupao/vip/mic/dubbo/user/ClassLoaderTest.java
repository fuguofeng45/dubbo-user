package com.gupao.vip.mic.dubbo.user;

import java.util.ArrayList;
import java.util.List;

public class ClassLoaderTest {

    public static void main(String[] args) {
        Object o = new Object();
        //System.out.println(o.getClass().getClassLoader());

        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        //System.out.println(classLoaderTest.getClass().getClassLoader());

        List list = new ArrayList();
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent().getParent());
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent());
        System.out.println(classLoaderTest.getClass().getClassLoader());

    }

}
