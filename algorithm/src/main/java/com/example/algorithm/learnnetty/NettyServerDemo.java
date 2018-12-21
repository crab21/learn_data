package com.example.algorithm.learnnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.Charset;

public class NettyServerDemo {
    private int port;


    public NettyServerDemo(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        try {
            new NettyServerDemo(8888).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void start() throws InterruptedException {

        NioEventLoopGroup bossgroup = new NioEventLoopGroup();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            serverBootstrap.group(bossgroup, group)
                    //设置启用Nagle的算法 true-->不启用  false-->启用
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("报告");
                            System.out.println("信息：有一客户端链接到本服务端");
                            System.out.println("IP:" + ch.localAddress().getHostName());
                            System.out.println("Port:" + ch.localAddress().getPort());
                            System.out.println("报告完毕");
                            //先设置心跳信息 初始化最先加载ß
                            ch.pipeline().addLast(new MyServerInitializer());
                            ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            ch.pipeline().addLast(new EchoServerHandler()); // 客户端触发操作
                            ch.pipeline().addLast(new ByteArrayEncoder());
                        }
                    });
            ChannelFuture cf = serverBootstrap.bind(3577).sync();
            System.out.println(NettyServerDemo.class + " 启动正在监听： " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync();
            bossgroup.shutdownGracefully().sync();
        }
    }
}
