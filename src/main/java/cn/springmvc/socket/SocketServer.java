package cn.springmvc.socket;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2015/7/1.
 */
public class SocketServer  implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(SocketServer.class);
    public boolean isServerRunning;
    public Thread serverThread;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.warn("Server Start ===========================>");
        isServerRunning = true ;
        serverThread =  new Thread(new ServerThread(isServerRunning,servletContextEvent.getServletContext()));
        serverThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.warn("Server Stop <============================");
        if (serverThread != null){
            try {
                serverThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
