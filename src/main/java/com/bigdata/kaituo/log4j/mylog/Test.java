package com.bigdata.kaituo.log4j.mylog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chang on 2018/11/25.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        logger.debug("this is debug;");
        logger.warn("this is warn;");
        logger.info("this is info;");
        logger.error("this is error;");
    }
}
