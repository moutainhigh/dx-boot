package com.dx.qq.socket;


import com.dx.qq.QQUser;
import com.dx.qq.robot.LuaQQRobot;
import com.dx.qq.robot.QQRobot;

public class MessageService extends Thread {

    private QQUser user = null;
    private MessageManager messagemanager = null;
    private Udpsocket socket = null;


    private QQRobot robot;

    public boolean running = true;

    private LuaQQRobot luarobot;

    public MessageService(QQUser _user, Udpsocket _socket, QQRobot _robot, LuaQQRobot _luarobot) {
        this.user = _user;
        this.socket = _socket;
        this.robot = _robot;
        this.luarobot = _luarobot;
        this.messagemanager = new MessageManager(this.user, this.socket, this.robot, this.luarobot);
    }

    @Override
    public void run() {
        while (this.running) {

            byte[] data = socket.receiveMessage();
            if (data != null) {
                messagemanager.manage(data);
            }
        }
    }


    public void kill() {
        this.running = false;
        try {
            this.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
