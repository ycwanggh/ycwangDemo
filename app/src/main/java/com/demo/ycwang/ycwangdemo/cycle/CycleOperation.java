package com.demo.ycwang.ycwangdemo.cycle;

import java.util.Timer;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/2/27 9:50
 */
public class CycleOperation {

    public static void main(String[] args) {
        timerOperation();
    }

    static Timer timer;

    public static void timerOperation() {
        timer = new Timer();

        long delay1 = 10 * 1000;
        long period1 = 1000;
        timer.schedule(new TimerTask("Job1"), delay1, period1);
    }

    public static int count;

    static class TimerTask extends java.util.TimerTask {
        public String jobName;


        public TimerTask(String jobName) {
            this.jobName = jobName;
        }

        @Override
        public void run() {
            count++;
            System.out.println("执行作业：" + jobName);
            System.out.println("count:" + count);
            if (count == 10) {
                timer.cancel();
            }
        }
    }


}
