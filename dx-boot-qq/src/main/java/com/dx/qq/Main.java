package com.dx.qq;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(final String[] args) {
        log.info("打开桌面端。。。。（支持：https://github.com/Saint-Theana）");
        MainApp app = new MainApp();
        app.start();
    }

}


