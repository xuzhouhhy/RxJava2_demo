package com.xuzhouhhy.rxjava.test;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;

/**
 * created by hanhongyun on 2019/2/17 12:25
 */
public class SchedulersWorkTest {

    public static void main(String... args) {
        Schedulers.newThread()
                .createWorker()
                .schedule(
                        new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(Thread.currentThread().getName());
                            }
                        }
                );
        Schedulers.newThread()
                .createWorker()
                .schedulePeriodically(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                }, 2, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000 * 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
