package com.dx.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/3/21
 */
@Component
public class NettyServer {


    /**
     * （1）new了两个NioEventLoopGroup，一个是boss，一个是work。
     * NioEventLoopGroup是一个线程组，boss线程组用于接收客户端的连接工作，work线程组用于处理数据。
     *
     * （2）在start方法中，首先new了一个ServerBootstrap，，名字叫bootstrap。
     * 它是netty用于启动NIO服务端的辅助启动类。目的是降低服务端的开发复杂度。
     *
     * （3）.group(boss, work)目的是将两个线程组传入，让其工作。
     *
     * （4）.channel(NioServerSocketChannel.class)就类比与NIO中的ServerSocketChannel。
     *
     * （5）.option(ChannelOption.SO_BACKLOG, 1024)配置TCP参数，将其中一个参数backlog设置为1024，
     * 表明临时存放已完成三次握手的请求的队列的最大长度。
     *
     * （6）.childOption(ChannelOption.SO_KEEPALIVE, true)设置TCP长连接,
     * 一般如果两个小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文。
     *
     * （7）.handler(new LoggingHandler(LogLevel.INFO))处理Log日志。
     *
     * （8）.childHandler，用于处理客户端的IO事件，比如有一个客户端发起请求，要读取数据，就可以使用这里面的类来处理这个事件。
     * 这是整个处理的核心。也是我们自己主要关注的类。
     *
     * （9）ChannelFuture cf = bootstrap.bind(8888).sync();绑定监听端口。使用sync方法阻塞一直到绑定成功。
     *
     * （10）下面通过一个if语句表明，如果绑定成功那就输出“服务端启动成功”。
     *
     * （11）最后将boss和work使用finally代码块优雅的退出。何为优雅今后再说。
     */


    EventLoopGroup boss = new NioEventLoopGroup();
    EventLoopGroup work = new NioEventLoopGroup();

    @PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new ServerUAVHandler());
                    }
                });
        ChannelFuture cf = bootstrap.bind(8888).sync();
        if (cf.isSuccess()) {
            System.out.println("启动成功");
        }
    }

    @PreDestroy
    private void destory() throws Exception {
        boss.shutdownGracefully();
        work.shutdownGracefully();
        System.out.println("关闭server");
    }
}

