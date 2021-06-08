package com.liuxin.learn.reloader;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = UserReloader.users;
        long now = System.currentTimeMillis();
        UserReloader.r.start();
        while (System.currentTimeMillis() - now < 5000){

        }

        // todo
        UserReloader.r.stop();

        UserReloader.r.start();
    }
}
