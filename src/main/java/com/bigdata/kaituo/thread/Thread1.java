package com.bigdata.kaituo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chang on 2017/2/26.
 */
public class Thread1 implements Runnable {


    public void run() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String time = sdf.format(date);
        Thread thisThread = Thread.currentThread();
        System.out.println("I am " + this.getClass().getName()
                + ". startTime=" + time
                + ". thisThread.getName()=" + thisThread.getName()
                + ". thisThread.getId()=" + thisThread.getId()
                + ". thisThread.getState()=" + thisThread.getState()
                + ". thisThread.isDaemon()=" + thisThread.isDaemon());
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am " + this.getClass().getName()
                + ". startTime=" + time + " over!"
                + ". endTime=" + sdf.format(new Date()));
    }
}
