package com.liuxin.learn.reloader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserReloader {
    //
    public static List<User> users;
    public static IReloader r;

    static {
        users = new ArrayList<>(16);
        r = ReloaderBulider.newReloader(1, TimeUnit.SECONDS, () -> {

            // todo
            users = getUsers();
            // filter
            System.out.println("test" + new Date());

            // 加工

            return users;
        });
        r.start();
    }

    private static List<User> getUsers() {
        // select * from user;
        return new ArrayList<>();
    }

}
