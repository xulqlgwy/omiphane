package cn.springmvc.socket;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by Administrator on 2015/7/1.
 */
public class ServerThread implements Runnable {
    private boolean isRunning;
    private int serverPort = 5189;
    private SocketProcesser socketProcesser;
    private ServletContext servletContext;
    public ServerThread(boolean isRunning,ServletContext servletContext){
        this.isRunning = isRunning;
        this.servletContext = servletContext;
    }

    @Override
    public void run() {
        while (isRunning){
            if (null == socketProcesser) {
                try {
                    socketProcesser = new SocketProcesser(serverPort,servletContext);
                    socketProcesser.listen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
