package com.dx;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Description: com.dx
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/4
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        e.pipeline().addLast("http-codec",new HttpServerCodec());
        e.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
        e.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
        e.pipeline().addLast("handler",new MyWebSocketHandler());
    }

}
