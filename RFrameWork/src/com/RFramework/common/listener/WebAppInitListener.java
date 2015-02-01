package com.RFramework.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangronghua on 15/1/31.
 */
public class WebAppInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(WebAppInitListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Entering");
        try {
            freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_SLF4J);
        } catch (ClassNotFoundException e) {
            logger.error("Class not found!", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
