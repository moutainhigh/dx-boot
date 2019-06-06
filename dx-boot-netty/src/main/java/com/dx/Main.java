package com.dx;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 程序的入口
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/4
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new MyWebSocketHandler());
            log.info("服务器等待客户端链接。。。");
            Channel channel = bootstrap.bind(8888).sync().channel();
            channel.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅的推出程序
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

}
