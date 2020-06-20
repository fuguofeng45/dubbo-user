package com.gupao.vip.mic.dubbo.user;

import com.gupao.vip.mic.dubbo.order.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    private volatile Integer i;

    public static void main(String[] args) throws IOException, InterruptedException {

        //用户下单过程
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");
        IOrderServices services = (IOrderServices) context.getBean("orderServices");
        DoOrderRequest request = new DoOrderRequest();
        request.setName("mic");
        DoOrderResponse response = services.doOrder(request);

        System.out.println(response);
        System.in.read();*/

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //用户支付过程
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");
                IPayServices services = (IPayServices) context.getBean("payServices");
                DoPayResponse response = services.doPay(null);
                System.out.println(response);
            }).start();
            TimeUnit.SECONDS.sleep(2);
        }

    }

}
