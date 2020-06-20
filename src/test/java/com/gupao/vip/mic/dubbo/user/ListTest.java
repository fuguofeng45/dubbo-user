package com.gupao.vip.mic.dubbo.user;

import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ListTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("");
        list.add("");
        //set.add()
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/
    }

}
