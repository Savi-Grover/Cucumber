package com.ford.auto.logging;

import org.joda.time.DateTime;

public class Logger {

    private static String INFOTAG = "Info";
    private static String ENTERMETHOD = "ENTERMETHOD";

    public static void LogEnterMethod(String message){
        String callerClass = Thread.currentThread().getStackTrace()[2].getClassName();
        String callerMethod = Thread.currentThread().getStackTrace()[2].getMethodName();

        Log(callerClass +"."+callerMethod +"()," +message, Logger.ENTERMETHOD);
    }

    public static void LogInfo(String message) {
        Log(message, Logger.INFOTAG);
    }

    private static void Log(String message, String logMessageType) {
        String timeStamp = DateTime.now().toString();
        String logMessage = timeStamp + "," + logMessageType + ", \"" + message + "\"";
        System.out.println(logMessage);
    }
}
