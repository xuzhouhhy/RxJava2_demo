package com.xuzhouhhy.rxjava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * created by hanhongyun on 2018/9/7 19:04
 */
//timer 和 interval 均默认在新线程。
public class TimerOperator {

    private static SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss.ssss");

    public static void main(String... args) {
        System.out.println(mDateFormat.format(new Date()));
        Disposable subscribe = Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println(mDateFormat.format(new Date()));
                        System.out.println(aLong);
                    }
                });

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
