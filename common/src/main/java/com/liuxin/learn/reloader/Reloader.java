package com.liuxin.learn.reloader;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Reloader {

    public <T> T reloader(int time, TimeUnit unit, Supplier<T> supplier) {
        return null;
    }

    public boolean start() {
        return true;
    }

    public boolean stop() {
        return true;
    }

}
