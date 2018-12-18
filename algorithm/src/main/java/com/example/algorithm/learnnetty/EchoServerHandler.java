package com.example.algorithm.learnnetty;

import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.SortedMap;

public class EchoServerHandler extends ChannelHandlerAdapter implements ChannelInboundHandler {

    @Override
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println(channelHandlerContext.channel().localAddress().toString() + " 通道已激活！");
    }

    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println(channelHandlerContext.channel().localAddress().toString() + " 通道不活跃！");
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);

        System.out.println("客户端收到服务器数据:" + Arrays.toString(con));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

    }
}
