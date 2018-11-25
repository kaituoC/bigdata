package com.bigdata.kaituo.log4j.mylog;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chang on 2018/11/25.
 */
public class ErrorDailyRollingFileAppender extends ShortenDailyRollingFileAppender {
    /**
     * 储存前面多少条日志信息
     */
    private Integer frontSize = 6;
    /**
     * 储存日志信息集合
     */
    private List<LoggingEvent> logEventList = new LinkedList<>();
    public final static String SEPARATOR = "------------------------------";

    @Override
    public void append(LoggingEvent event) {
        pushLoggingEvent(event);
        LocationInfo locationInfo = new LocationInfo("", SEPARATOR, "", "0");
        Level level = event.getLevel();
        LoggingEvent separator = new LoggingEvent(event.fqnOfCategoryClass, event.getLogger(), event.timeStamp, level, "", event.getThreadName(), event.getThrowableInformation(), event.getNDC(), locationInfo, event.getProperties());
        if (level.toInt() == Level.ERROR_INT) {
            super.append(separator);
            for (LoggingEvent loggingEvent : logEventList) {
                super.append(loggingEvent);
            }
        }
    }

    private void pushLoggingEvent(LoggingEvent event) {
        int diff = logEventList.size() - frontSize + 1;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) logEventList.remove(i);
        }
        logEventList.add(event);
    }

    public Integer getFrontSize() {
        return frontSize;
    }

    public void setFrontSize(Integer frontSize) {
        this.frontSize = frontSize;
    }

}
