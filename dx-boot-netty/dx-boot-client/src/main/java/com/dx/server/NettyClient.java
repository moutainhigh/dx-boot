package com.dx.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description: com.dx.client.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/3/21
 */
@Component
public class NettyClient {


    /**
     * （1）首先，只new了一个NioEventLoopGroup，因为不需要处理连接，所以客户端只关注于读写数据的操作。
     *
     * （2）在start方法内部创建了一个Bootstrap，名字是b，意思是客户端的启动类。
     *
     * （3）接着使用option配置一些参数。
     *
     * （4）使用handler方法传递一个类，在内部有一个ClientHandler类，同样也是客户端的核心。
     *
     * （5）接下来链接服务器，指定地址和端口。最终关闭链接优雅的推出线程组。
     *
     */

    private SocketChannel socketChannel;
    EventLoopGroup group = new NioEventLoopGroup();

    @PostConstruct
    public void start() throws Exception {
        //boss 线程组用于处理连接工作
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
            //绑定端口
            ChannelFuture cf = b.connect("127.0.0.1", 8888).sync();
            if (cf.isSuccess()) {
                System.out.println("链接服务器成功");
            }
            cf.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
