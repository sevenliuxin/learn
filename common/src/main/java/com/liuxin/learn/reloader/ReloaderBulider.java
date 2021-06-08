package com.liuxin.learn.reloader;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ReloaderBulider {

    public static <T> IReloader newReloader(int time, TimeUnit unit, Supplier<T> supplier) {
        Reloader r = new Reloader();
        r.setTime(time);
        r.setUnit(unit);
        r.setSupplier(supplier);

        return r;
    }
}
