package com.bigdata.kaituo.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chang on 2017/2/22.
 */
public class Log4jDemo {

    Logger goldLogger = LoggerFactory.getLogger("gold_log");
    Logger chargeLogger = LoggerFactory.getLogger("charge_log");
    Logger activeLogger = LoggerFactory.getLogger("active_log");
    Logger gamePlayLogger = LoggerFactory.getLogger("game_play_log");
    Logger onlineLogger = LoggerFactory.getLogger("online_log");
    Logger propLogger = LoggerFactory.getLogger("prop_log");
    Logger registerLogger = LoggerFactory.getLogger("register_log");
    Logger timerLogger = LoggerFactory.getLogger(Log4jDemo.class);

    public void setSource(Object obj,int loggerType) throws Exception {

        if(obj == null) {
            return;
        }

        switch(loggerType) {
            case 0 :
                goldLogger.info(obj.toString());
                break;
            case 1 :
                chargeLogger.info(obj.toString());
                break;
            case 2 :
                activeLogger.info(obj.toString());
                break;
            case 3 :
                gamePlayLogger.info(obj.toString());
                break;
            case 4 :
                onlineLogger.info(obj.toString());
                break;
            case 5 :
                propLogger.info(obj.toString());
                break;
            case 6 :
                registerLogger.info(obj.toString());
                break;
            default :
                throw new Exception("Type not suitable.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello Word!");
        System.out.println("Hello Word!");
        Log4jDemo abservable = new Log4jDemo();
        try {
            abservable.setSource("gold_log", LoggerType.GOLD_LOG);
            abservable.setSource("charge_log", LoggerType.CHARGE_LOG);
            abservable.setSource("active_log", LoggerType.ACTIVE_ACCOUNT);
            abservable.setSource("game_play_log", LoggerType.GAME_PLAY);
            abservable.setSource("online_player", LoggerType.ONLINE_PLAYER);
            abservable.setSource("prop_log", LoggerType.PROP_LOG);
            abservable.setSource("register_log", LoggerType.REGISTER_LOG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        abservable.timerLogger.info("This is timerLogger INFO message!");
    }

}


class LoggerType {
    public static int GOLD_LOG = 0;
    public static int CHARGE_LOG = 1;
    public static int ACTIVE_ACCOUNT = 2;
    public static int GAME_PLAY = 3;
    public static int ONLINE_PLAYER = 4;
    public static int PROP_LOG = 5;
    public static int REGISTER_LOG = 6;
}
