package com.xuzhouhhy.rxjava.test;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * created by hanhongyun on 2019/2/17 12:56
 */
public class RecursiveSchedulerTest {

    public static void main(String... args) {
        Scheduler.Worker worker = Schedulers.newThread()
                .createWorker();
        worker.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(System.currentTimeMillis());
                        worker.schedule(this);
                    }
                }
        );

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
