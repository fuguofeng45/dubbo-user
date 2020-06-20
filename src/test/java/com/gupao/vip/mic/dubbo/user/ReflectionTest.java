package com.gupao.vip.mic.dubbo.user;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1 new 一个
       /* TargetClass targetClass = new TargetClass();
        Class<?> clazz = targetClass.getClass();*/
        //反射
        Class<?> clazz = Class.forName("com.gupao.vip.mic.dubbo.user.TargetClass");
        Method[] methods = clazz.getDeclaredMethods();
        methods[0].setAccessible(true);
    }

}
