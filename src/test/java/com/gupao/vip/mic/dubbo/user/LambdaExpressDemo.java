package com.gupao.vip.mic.dubbo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class LambdaExpressDemo {

    public static void main(String[] args) {
       /*Foo foo = new Foo() {
           @Override
           public void sayHello() {
               System.out.println(1);
           }
       };
       foo.sayHello();*/

        Foo foo = (i) -> {
            return i;
        };
        foo.mul1();
    }

}

@FunctionalInterface
interface  Foo{

    public String sayHello(String instr);

    default int mul(){
        return 1;
    }

    default int mul1(){
        return 1;
    }

    static void f1(){

    }

    static void f2(){

    }

}
