package com.gupao.vip.mic.dubbo.user;

import com.sun.deploy.net.proxy.ProxyUnavailableException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest implements Runnable{

    private List<String> list = null;

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(new ListTest(list)).start();
        }
    }

    public ListTest(List list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.list.add(UUID.randomUUID().toString().substring(0, 8));
            System.out.println(list);
        }

    }
}
