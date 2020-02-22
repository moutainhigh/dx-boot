package com.dx.qq;

import com.dx.qq.socket.LoginManager;
import com.dx.qq.utile.Util;

import javax.net.ssl.HttpsURLConnection;

/**
 * Description: com.dx.qq
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/1/30
 */
public class MainApp extends Thread {

    private QQUser user;

    @Override
    public void run() {
        try {
            Util.trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(Util.hv);
            this.startloginprocess();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-0);
        }
    }

    private void startloginprocess() {
        String qq = "2853385916";
        String password = "ks37285505..";
        byte[] passwordmd5 = new byte[0];
        LoginManager manager = null;
        passwordmd5 = Util.MD5(password);
        manager = new LoginManager(Long.parseLong(qq), passwordmd5);
        manager.st();
        this.user = manager.user;
    }

}
