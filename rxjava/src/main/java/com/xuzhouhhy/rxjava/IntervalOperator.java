package com.xuzhouhhy.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * created by hanhongyun on 2018/9/7 19:24
 */
public class IntervalOperator {

    public static void main(String... args) {
//        long startTime = System.currentTimeMillis();

//        Disposable subscribe = Observable.interval(1, 2, TimeUnit.SECONDS)
//                .subscribe((Long aLong) -> {
//                    System.out.println(System.currentTimeMillis());
//                    System.out.println("OnNext:" + aLong);
//                });

        Disposable subscribe = Observable.interval(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("OnNext:" + aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("onSubscribe:" + disposable.isDisposed());
                    }
                });

        try {
            Thread.sleep(1000 * 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
