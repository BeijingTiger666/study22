package com.study.ws.thd;

public class TicketThread extends Thread{

    @Override
    public void run() {
        System.out.println("开始买票了...");
    }

}
