package com.xuzhouhhy.rxjava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * created by hanhongyun on 2019/2/21 16:08
 */
public class FromCallableTest {

    public static void main(String... args) {
        Disposable subscribe = Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "aaa" + "bbb";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(SimpleDateFormat.getTimeInstance().format(new Date()) + " value:" + s);
            }
        });
    }

}
