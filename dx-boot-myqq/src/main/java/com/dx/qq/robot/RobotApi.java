package com.dx.qq.robot;


import com.dx.qq.QQUser;
import com.dx.qq.message.SendMessage;
import com.dx.qq.sdk.API;
import com.dx.qq.sdk.MessageFactory;
import com.dx.qq.socket.Udpsocket;
import com.dx.qq.utile.Util;

public class RobotApi implements API {

    private Udpsocket socket = null;
    private QQUser user = null;

    public RobotApi(Udpsocket _socket, QQUser _user) {
        this.user = _user;
        this.socket = _socket;
        Util.api = this;
    }

    @Override
    public void SendGroupMessage(MessageFactory factory) {

        SendMessage.SendGroupMessage(this.user, this.socket, factory);

    }

    @Override
    public void SendFriendMessage(MessageFactory factory) {

        SendMessage.SendFriendMessage(this.user, this.socket, factory);

    }


}
