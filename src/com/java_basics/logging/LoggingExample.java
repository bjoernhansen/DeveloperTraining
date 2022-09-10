package com.java_basics.logging;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.io.*;
import java.sql.SQLException;


public class LoggingExample{
    
    /* Get the class name to be printed on */
    static Logger log = LogManager.getLogger(LoggingExample.class.getName());
    
    
    
    public static void main(String[] args)throws IOException,SQLException{
        // Nachlesen zur Konfiguration: https://logging.apache.org/log4j/2.x/manual/configuration.html
        
        
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is a error message");
        log.log(Level.ERROR, "This is a error message, too.");
        
        logLogLevel();
        
        // Changing Log-Level
        Configurator.setRootLevel(Level.ERROR);
        logLogLevel();
        
        // Changes Root Looger Level without using Configurator, which is not part of public api
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        loggerConfig.setLevel(Level.DEBUG);
        ctx.updateLoggers();
        logLogLevel();
        
        // diese Anweisung wiegt offenbar am stärksten, die anderen kommen nicht mehr zum Tragen, wenn diese vorher steht
        Configurator.setLevel("com.java_basics.logging.LoggingExample", Level.INFO);
        logLogLevel();
    }
    
    private static void logLogLevel()
    {
        log.error("Current log level is: " + log.getLevel());
    }
    
}
