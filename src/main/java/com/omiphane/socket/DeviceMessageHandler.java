package com.omiphane.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 *
 * Created by wyxuliquan on 2016/11/14.
 */
public class DeviceMessageHandler extends SimpleChannelInboundHandler<String>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"say :" + msg);

        ctx.writeAndFlush("welcome to "+ InetAddress.getLocalHost()+"service !");

        super.channelActive(ctx);
    }
}
