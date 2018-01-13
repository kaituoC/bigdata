package com.bigdata.kaituo.schedule;

import com.bigdata.kaituo.thread.Thread1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chang on 2017/3/16.
 */
public class ScheduleDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new Thread1(), 0, 1000, TimeUnit.MILLISECONDS);
    }


}
