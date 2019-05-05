package com.demo.ycwang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ycwang
 * @Date: 2019/1/22 10:19
 * @Description:
 */
public class ThreadTest {

    public static class RunnableTest implements Runnable {


        private long i = 0;
        private volatile boolean interrupt = true;

        @Override
        public void run() {
            while (/*!Thread.currentThread().isInterrupted()*/interrupt) {
                i++;
                System.out.println("i=" + i);
            }

            System.out.println("stop");
        }

        void cancel() {
            interrupt = false;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);


        System.out.println("before start");
        thread.start();
        System.out.println("after start");


        System.out.println("before sleep");
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("after sleep");


        System.out.println("before cancel");
//        thread.interrupt();
        runnableTest.cancel();
        System.out.println("after cancel");

    }

}
