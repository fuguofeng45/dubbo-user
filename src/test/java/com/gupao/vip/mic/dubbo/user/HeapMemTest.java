package com.gupao.vip.mic.dubbo.user;

import java.util.Random;

public class HeapMemTest {

    public static void main(String[] args) {
        /*long m1 = Runtime.getRuntime().totalMemory();
        long m2 = Runtime.getRuntime().maxMemory();
        System.out.println(m2 / (double) 1024 / 1024);
        System.out.println(m1 / (double) 1024 / 1024);*/
        String str = "fgf45";
        /*while(true){
            str += str + new Random().nextInt(Integer.MAX_VALUE) + new Random().nextInt(Integer.MAX_VALUE);
        }*/
        byte[] byt = new byte[40 * 1024 * 1024];
    }

}
