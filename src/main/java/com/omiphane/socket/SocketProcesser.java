package com.omiphane.socket;

import com.omiphane.service.NetProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * Created by xulq on 2015/7/1.
 */
public class SocketProcesser {
    private static final Logger logger = LoggerFactory.getLogger(SocketProcesser.class);

    static String name = "";
    protected Selector selector;

    protected CharsetDecoder decoder;
    static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();

    private NetProcessService deviceNetInfo;
    private ServletContext servletContext;



    public SocketProcesser(int port,ServletContext servletContext) throws IOException {
        selector = this.getSelector(port);
        Charset charset = Charset.forName("GB2312");
        decoder = charset.newDecoder();
        this.servletContext = servletContext;

        if(deviceNetInfo == null){
            ApplicationContext beans = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//            deviceNetInfo = (NetProcessService)beans.getBean("deviceNetInfo");
//            deviceNetInfo.setDecoder(decoder);
        }
    }


    // 获取Selector
    protected Selector getSelector(int port) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        Selector sel = Selector.open();
        server.socket().bind(new InetSocketAddress(port));
        server.configureBlocking(false);
        server.register(sel, SelectionKey.OP_ACCEPT);
        return sel;
    }


    // 监听端口
    public void listen() {
        try {
            for (;;) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    iterator.remove();
                    process(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 处理事件
    protected void process(SelectionKey key)  {
        try {
            if (key.isAcceptable()) { // 接收请求
                ServerSocketChannel server = (ServerSocketChannel) key.channel();
                SocketChannel channel = server.accept();

                logger.warn("有连接进入:"+channel.getRemoteAddress().toString());
                //设置非阻塞模式
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            } else if (key.isReadable()) { // 读信息
                SocketChannel channel = (SocketChannel) key.channel();
                //处理收到的网络数据

                deviceNetInfo.processChanel(channel);
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);

            } else if (key.isWritable()) { // 写事件
                SocketChannel channel = (SocketChannel) key.channel();
                String name = (String) key.attachment();

                ByteBuffer block = encoder.encode(CharBuffer.wrap("["+channel.toString()+"] 发送数据:" + name));


                channel.write(block);
                key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
            }
        }catch (IOException e){
            e.printStackTrace();
            key.cancel();
        }
    }
}
