package com.study.ws.thd;

public class StudyThread extends Thread{
    private int num;
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
