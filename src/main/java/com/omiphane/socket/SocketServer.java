package com.omiphane.socket;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2015/7/1.
 */
public class SocketServer  implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(SocketServer.class);

    private NettyServer nettyServer = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.warn("Server Start ===========================>");
//        nettyServer = new NettyServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.warn("Server Stop <============================");

    }
}
