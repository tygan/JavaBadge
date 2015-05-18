package org.familysearch.test;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

/**
 * Created by tyganshelton on 5/11/2015.
 * Example of using slf4j and logback to log to the console and a file. File stored in c:/logs.
 */
public class LoggingExample {


    public static void main(String[] args) {
        Logger logger = (Logger) LoggerFactory.getLogger(LoggingExample.class);
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        logger.error("Hello Error");
        int ex1 = 27;
        logger.warn("Hello Warn: int ex1 = {}", ex1);
        logger.info("Hello Info");
        String ex2 = "llamas";
        logger.debug("Hello Debug: ex1 + ex2 = \"{} {}\"", ex1, ex2);

    }
}
