package com.gupao.vip.mic.dubbo.user;

import java.util.concurrent.TimeUnit;

public class LockTest {

    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                phone.sendSMS();
                //phone.sayHello();

                //phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}

class Phone {

    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(" send Email ");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println(" send SMS ");
    }

    public void sayHello() throws Exception{
        System.out.println("hello!");
    }

}
