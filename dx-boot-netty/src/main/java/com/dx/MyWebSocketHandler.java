package com.dx;

import com.dx.config.NettyConfig;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import lombok.extern.java.Log;

import java.util.Date;

/**
 * Description: 接受、处理 scoket请求的核心处理类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/4
 */
@Log
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    private static final  String WEB_SOKET_URL = "ws://localhost:8888/websocket";

    /**
     * 服务端处理websocket请求的核心方法
     * @param context
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext context, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest){
            //处理客户端发起的http握手业务员
            handHttpRequest(context,(FullHttpRequest) msg);

        }else if (msg instanceof WebSocketFrame){
            //处理websocket连接业务
            handWebsocketFrame(context,(WebSocketFrame) msg);
        }

    }

    private void handWebsocketFrame(ChannelHandlerContext ctx ,WebSocketFrame frame){
        //判断是否是关闭websocket指令
        if (frame instanceof CloseWebSocketFrame){
            handshaker.close(ctx.channel(),((CloseWebSocketFrame) frame).retain());
        }
        //判断是否是ping消息
        if (frame instanceof PingWebSocketFrame){
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        //判断是否是二进制消息，如果是二进制，抛出异常
        if (!(frame instanceof TextWebSocketFrame)){
            log.info("目前不支持二进制消息传输！！");
            throw new RuntimeException("不支持消息" + this.getClass().getName());
        }

        //返回应哒消息
        //获取客户端向服务端发送的消息
        String request = ((TextWebSocketFrame)frame).text();
        log.info("服务器端收到消息是-->"  + request);
        TextWebSocketFrame textWebSocketFrame
                = new TextWebSocketFrame(new Date().toString() + ctx.channel().id() + "  --->  " + request);

        //服务端向每个链接的客户端群发消息
        NettyConfig.group.writeAndFlush(textWebSocketFrame);

    }

    /**
     * 处理客户端向服务器端发起的http握手请求业务
     * @param ctx
     * @param req
     */
    private void handHttpRequest(ChannelHandlerContext ctx,FullHttpRequest req){
        if (!req.getDecoderResult().isSuccess() || !("websocket").equals(req.headers().get("Upgrade"))){
            sendHttpResponse(ctx,req,new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory webSocketServerHandshakerFactory
                = new WebSocketServerHandshakerFactory(WEB_SOKET_URL,null,false);
        handshaker = webSocketServerHandshakerFactory.newHandshaker(req);
        if (handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        }else {
            handshaker.handshake(ctx.channel(),req);
        }
    }

    /**
     * 服务器端向客户端响应消息
     * @param ctx
     * @param req
     * @param res
     */
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res){
        if (res.getStatus().code()!=200){
            ByteBuf byteBuf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(byteBuf);
            byteBuf.release();
        }
        //服务端向客户端发送数据
        ChannelFuture channelFuture = ctx.channel().writeAndFlush(res);

        if (res.getStatus().code()!=200){
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 客户端与服务器端连接时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.add(ctx.channel());
        log.info("客户端与服务器端建立了连接。。。");
    }

    /**
     * 客户端与服务器端断开时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.remove(ctx.channel());
        log.info("客户端与服务器端连接关闭。。。");
    }

    /**
     * 服务端接受客户端来的数据结束之后
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        log.info("数据发送完毕");
    }

    /**
     * 工程出现异常时候调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
        log.info("出现异常。。。");
    }
}
