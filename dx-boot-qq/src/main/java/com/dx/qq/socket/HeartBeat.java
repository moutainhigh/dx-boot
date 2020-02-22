package com.dx.qq.socket;

import com.dx.qq.QQUser;
import com.dx.qq.packages.SendPackageFactory;
import com.dx.qq.utile.Util;

import java.util.Date;

public class HeartBeat implements Runnable {

    private QQUser user = null;
    private long time_miles = 0;
    private Udpsocket socket = null;
    LoginManager manager;
    private boolean running = true;

    public HeartBeat(QQUser _user, LoginManager _manager) {
        this.user = _user;
        this.manager = _manager;
        this.socket = this.manager.socket;
    }

    public void run() {
        while (this.running) {
            try {
                if (!this.user.offline) {
                    this.user.offline = true;
                } else {
                    //this.manager.update("offline");

                    //break;
                }
                byte[] data = SendPackageFactory.get0058(this.user);
                time_miles = new Date().getTime();
                socket.sendMessage(data);
                Thread.currentThread().sleep(20000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Util.log("----------心跳停止----------");
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
