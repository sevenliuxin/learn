package com.liuxin.learn.reloader;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * 定时执行任务实现
 * @param <T>
 */
public class Reloader<T> implements IReloader {
    private int time;
    private TimeUnit unit;
    private Supplier<T> supplier;
    private String status;
    private String OFF = "OFF";
    private String ON = "ON";
    private ReentrantLock lock = new ReentrantLock();

    public void setTime(int time) {
        this.time = time;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public void setSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * 记录次数
     * 接口调用时长大于间隔时间
     *
     * @return
     */
    @Override
    public boolean start() {
        lock.lock();//cas实现
        if (status == null || status == OFF) {
            System.out.println("start启动");
            status = ON;
            new Thread(() -> {
                //循环优化
                while (status == ON) {
                    supplier.get();
                    try {
                        Thread.sleep(unit.toMillis(time));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程结束了");
            }).start();
        } else {
            System.out.println("start已经启动");
            return false;
        }
        lock.unlock();

        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("线程中断了" + new Date());
        status = OFF;
        return true;
    }

}
