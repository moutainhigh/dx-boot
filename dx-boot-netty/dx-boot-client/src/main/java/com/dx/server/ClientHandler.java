package com.dx.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Description: com.dx.client.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/3/21
 */
public class ClientHandler extends ChannelHandlerAdapter {

    /**
     *
     */



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        byte[] req = "I love you".getBytes();
        ByteBuf first = Unpooled.buffer(req.length);
        first.writeBytes(req);
        ctx.writeAndFlush(first).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        if("no".equals(body)){
            ByteBuf resp = Unpooled.copiedBuffer("不灰心不丧气，继续我爱你".getBytes());
            ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        }
    }
}

