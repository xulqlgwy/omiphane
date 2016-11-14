package com.omiphane.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *
 * Created by wyxuliquan on 2016/11/14.
 */
public class NettyServer {
    private static final int portNumber = 7878;

    public NettyServer(){

        EventLoopGroup leaderLoopGroup= new NioEventLoopGroup();
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(leaderLoopGroup,workerLoopGroup);
            sb.channel(NioServerSocketChannel.class);
            sb.childHandler(new DeviceReceiveServerInitializer());

            ChannelFuture cf = sb.bind(portNumber).sync();
            sb.option(ChannelOption.SO_KEEPALIVE, true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            leaderLoopGroup.shutdownGracefully();
            workerLoopGroup.shutdownGracefully();
        }

    }

}
