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
import java.util.Vector;

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

    /**
     * N核服务器，通过执行业务的单线程分析出本地计算时间为x，等待时间为y，
     * 则工作线程数（线程池线程数）设置为 N*(x+y)/x，能让CPU的利用率最大化
     * @throws InterruptedException
     */
    private void start() throws InterruptedException {

        //-Dnetty.server.parentgroup.size=2 -Dnetty.server.childgroup.size=4

        //boss用来接收进来的连接
        NioEventLoopGroup bossgroup = new NioEventLoopGroup(32);
        //用来处理已经被接收的连接
        NioEventLoopGroup group = new NioEventLoopGroup(32);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap= serverBootstrap.group(bossgroup, group)

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
                    })
                    //设置启用Nagle的算法 true-->不启用  false-->启用
                    .option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.TCP_NODELAY, true);
            ChannelFuture cf = serverBootstrap.bind(3577).sync();
            System.out.println(NettyServerDemo.class + " 启动正在监听： " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync();
            bossgroup.shutdownGracefully().sync();
        }
    }
}
