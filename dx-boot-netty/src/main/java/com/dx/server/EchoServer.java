package com.dx.server;

import com.dx.security.handler.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Description: com.dx.server
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/15
 */
public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    /**
     * 　　说明：其流程大致如下
     *
     * 　　① 创建NioEventLoopGroup实例来处理事件，如接受连接，读写数据等。
     *
     * 　　② 创建ServerBootstrap实例。
     *
     * 　　③ 指定服务端绑定的端口。
     *
     * 　　④ 设置childHandler来处理每一次连接。
     *
     * 　　⑤ 使用ServerBootstrap的bind方法进行绑定并同步直至其完成绑定。
     */
    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            // 绑定端口，开始接收连接
            ChannelFuture f = b.bind().sync();
            System.out.println("服务器开始监听的端口是   Server start listen at " + port);
            // 等待服务器socket关闭
            f.channel().closeFuture().sync();
            System.out.println("关闭");
        } finally {
            group.shutdownGracefully();
            System.out.println("错误，最后关闭了。。。");
        }
    }


    public static void main(String[] args) throws Exception {

        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new EchoServer(port).start();
    }
}