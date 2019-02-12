package com.xuzhouhhy.rxjava.test;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * created by hanhongyun on 2019/2/12 16:18
 */
public class JustVsFrom {

    public static void main(String... args) {
        //just one source
        Disposable subscribe = Observable.just("aaa")
                .subscribe(e -> System.out.println(e));

        System.out.println("----------------------");

        Disposable subscribe2 = Observable.just(new String[]{"aaa", "bbb"})
                .subscribe(strings -> {
                    for (String s : strings) {
                        System.out.print(s);
                        System.out.print("/");
                    }
                    System.out.print("\n");
                });

        System.out.println("----------------------");

        //just two sources
        Disposable subscribe1 = Observable.just("aaa", "bbb")
                .subscribe(s -> {
                    System.out.println(s);
                });

        System.out.println("----------------------");

        //from one source
        //RxJava2 remove Observable.from()
        // add Observable.fromCallable() ect.
    }

}
