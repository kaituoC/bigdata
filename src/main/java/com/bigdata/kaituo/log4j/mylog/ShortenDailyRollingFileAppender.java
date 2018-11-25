package com.bigdata.kaituo.log4j.mylog;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by chang on 2018/11/25.
 */
public class ShortenDailyRollingFileAppender extends DailyRollingFileAppender {

    /**
     * 排除page的名称
     */
    private String excludeClassPrefix;
    /**
     * 排除page的名称转数组
     */
    private String[] excludeClassPrefixArray;

    @Override
    public void append(LoggingEvent event) {
        LocationInfo locationInfo = event.getLocationInformation();
        locationInfo.fullInfo = reconstructionFullInfo(event.getLocationInformation());
        super.append(event);
    }

    /**
     * 重构fullInfo classname改为简写
     *
     * @param locationInfo
     * @return
     * @author sourny
     * @data 2017年8月7日
     */
    private String reconstructionFullInfo(LocationInfo locationInfo) {
        String quotes = locationInfo.getClassName();
        StringBuilder buf = new StringBuilder();
        if (quotes != null) {
            boolean isFilter = false;
            for (String string : excludeClassPrefixArray) {
                if (quotes.startsWith(string)) {
                    isFilter = true;
                    break;
                }
            }
            if (isFilter) return locationInfo.fullInfo;
            String[] split = quotes.split("\\.");
            int length = split.length - 1;
            for (int i = 0; i < length; i++) {
                buf.append(split[i].substring(0, 1) + ".");
            }
            buf.append(split[length]);
            buf.append(".");
            buf.append(locationInfo.getMethodName());
            buf.append("(line:");
            buf.append(locationInfo.getLineNumber());
            buf.append(")");
            quotes = buf.toString();
        } else {
            quotes = LocationInfo.NA;
        }
        return quotes;
    }

    private void initAbbreviationClassPrefixArray() {
        excludeClassPrefixArray = new String[]{};
        if (StringUtils.isNotBlank(excludeClassPrefix)) excludeClassPrefixArray = excludeClassPrefix.split(",");
    }

    public String getAbbreviationClassPrefix() {
        return excludeClassPrefix;
    }

    public void setAbbreviationClassPrefix(String abbreviationClassPrefix) {
        this.excludeClassPrefix = abbreviationClassPrefix;
        initAbbreviationClassPrefixArray();
    }

}
