package com.study.ws.test.thd;

import com.study.ws.thd.StudyThread;
import com.study.ws.thd.StudyThread2;

public class ThdTest {

    public static void main(String[] args) {
        final StudyThread studyThread = new StudyThread();
        final Thread thread = new Thread(studyThread);
        final StudyThread2 studyThread2 = new StudyThread2();
        final Thread thread2 = new Thread(studyThread2);
        thread.start();
        thread2.start();
    }
}

