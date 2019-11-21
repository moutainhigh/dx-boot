package com.dx.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/3/21
 */
public class ServerUAVHandler extends ChannelHandlerAdapter {

    /**
     * （1）ServerUAVHandler继承了ChannelHandlerAdapter主要是用于处理网络的读写事件。
     *
     * （2）重写了channelRead读方法，在这个方法内部可以读取客户端的请求信息。其中一个参数msg就是封装的信息对象。
     * 我们可以在内部通过ByteBuf这个工具类进行读取。内部实现的细节就不再多描述了。
     *
     */


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("客户端信息是：" + body);
        ByteBuf resp = Unpooled.copiedBuffer("no".getBytes());
        ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }
}

