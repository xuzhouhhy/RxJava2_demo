package com.xuzhouhhy.rxjava.test;

import com.xuzhouhhy.rxjava.bean.Data;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * created by hanhongyun on 2019/2/12 15:15
 */
public class JustOperatorTest {

    public static void main(String... args) {
        final Observable<Data> observable = Observable.just(new Data("aaa"), new Data("bbb"));
        Disposable subscribe = observable.subscribe(new Consumer<Data>() {
            @Override
            public void accept(Data data) throws Exception {
                data.content = "ccc";
                System.out.println(data.content);
            }
        });
        Disposable subscribe1 = observable.subscribe(new Consumer<Data>() {
            @Override
            public void accept(Data data) throws Exception {
                System.out.println(data.content);
            }
        });
    }

}
