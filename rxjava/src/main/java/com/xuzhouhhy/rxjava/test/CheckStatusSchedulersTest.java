package com.xuzhouhhy.rxjava.test;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * created by hanhongyun on 2019/2/17 13:07
 */
public class CheckStatusSchedulersTest {

    private int status = 0;

    public static void main(String... args) {

        CheckStatusSchedulersTest test = new CheckStatusSchedulersTest();
        Scheduler.Worker worker = Schedulers.newThread()
                .createWorker();

        worker.schedule(new Runnable() {
            @Override
            public void run() {
                while (!worker.isDisposed()) {
                    System.out.println("worker not disposed ");
                    if (test.getStatus() == 10) {
                        worker.dispose();
                    }
                }
                System.out.println("Runnable end");
            }
        });

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getStatus() {
        return status++;
    }

}
