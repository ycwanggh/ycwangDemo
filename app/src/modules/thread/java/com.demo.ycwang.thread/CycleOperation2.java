package com.demo.ycwang.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/2/27 10:14
 */
public class CycleOperation2 {

    public static void main(String[] args) {
        testScheduledExecutorWay();
    }


    public static void testScheduledExecutorWay() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        int initDelay = 1;
        int initPeriod = 5;
        service.scheduleAtFixedRate(new ScheduledExecutorTest("Job1"), initDelay, initPeriod, TimeUnit.SECONDS);

        int initDelay2 = 1;
        int initPeriod2 = 1;
        service.scheduleAtFixedRate(new ScheduledExecutorTest("Job2"), initDelay2, initPeriod2, TimeUnit.SECONDS);


    }

    static class ScheduledExecutorTest implements Runnable {

        private String jobName;

        public ScheduledExecutorTest(String jobName) {
            super();
            this.jobName = jobName;
        }

        @Override
        public void run() {
            System.out.println(getNowTime() + "执行作业：" + jobName);
        }
    }

    public static String getNowTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");// 可以方便地修改日期格式
        return dateFormat.format(now);
    }

}
