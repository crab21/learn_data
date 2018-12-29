package com.example.algorithm.learnnetty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //   调用read函数的时间   写入通道时间   所有的时间    时间的格式

        pipeline.addLast(new IdleStateHandler(50000, 0, 0, TimeUnit.SECONDS));
        pipeline.addLast(new HeartChannelAdpter());
    }
}
