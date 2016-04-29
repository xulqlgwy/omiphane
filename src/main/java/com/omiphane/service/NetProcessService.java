package com.omiphane.service;

import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Administrator on 2015/7/9 0009.
 */
public interface NetProcessService {
    /**
     * 获取并处理网络数据
     * @param socketChannel
     * 返回DevId作为SelectorKey的标识
     */
    public String processChanel(SocketChannel socketChannel);

    public void processLogin(SocketChannel socketChannel);

    public String processData( byte[] byteBuffer, Integer len);

    public void setDecoder(CharsetDecoder decoder) ;

}
