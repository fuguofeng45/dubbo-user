package com.gupao.vip.mic.dubbo.user;

import java.util.ArrayList;
import java.util.List;

public class TicketSale {

    public static void main(String[] args) {
        TicketSaler ticketSaler = new TicketSaler();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticketSaler.saleTicket();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticketSaler.saleTicket();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticketSaler.saleTicket();
            }
        }, "C").start();
    }

}
class TicketSaler{

    private volatile int ticketNumber = 50;

    public void saleTicket(){
        synchronized (this){
            if(ticketNumber > 0){
                ticketNumber--;
                System.out.println(Thread.currentThread().getName() + " 已经买票 ==> " + ticketNumber);
            }
        }
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

}
