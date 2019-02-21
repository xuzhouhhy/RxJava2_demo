package com.xuzhouhhy.rxjava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * created by hanhongyun on 2019/2/21 15:34
 */
public class RangeTest {

    public static void main(String... args) {
        Disposable subscribe = Observable.range(2, 10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(SimpleDateFormat.getTimeInstance().format(new Date()) + " value:" + integer);
                    }
                });

        Disposable subscribe1 = Observable.intervalRange(2, 10, 2, 1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println(SimpleDateFormat.getTimeInstance().format(new Date()) + " value:" + aLong);
                    }
                });

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
