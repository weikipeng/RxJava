package com.pengjunwei.test;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import java.util.concurrent.TimeUnit;

public class TestRxJava {
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public static void main(String args[]) {
        TestRxJava testRxJava = new TestRxJava();
        testRxJava.testSubscription();
        while (true){

        }
    }

    public void testSubscription(){
//        compositeSubscription;
        Subscription subscription = Observable.just(112233).delay(3, TimeUnit.SECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("testSubscription 000===>" + integer);
            }
        });

        compositeSubscription.add(subscription);
        compositeSubscription.unsubscribe();

        Subscription subscription2 = Observable.just(334455).delay(1, TimeUnit.SECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("testSubscription 000===>" + integer);
            }
        });

        compositeSubscription.add(subscription2);
    }

    public static void testStep(){
        //
//        String aString = "112233";
//
//        System.out.println("ss===>"+aString.substring(0,aString.length()));


//        Observable.just("Hello RxJava").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("sss===>"+s);
//            }
//        });


//        Observable.just("Hello RxJava","11","22").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("sss===>"+s);
//            }
//        });


//        Observable.just("Hello RxJava").subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        });

//        //操作符
//
//        Observable.just("Hello world")
//                .map(String::length).subscribe(word -> {
//            System.out.println("got " + word + " @ " + Thread.currentThread().getName());
//        });

        //线程调度
        Observable.just("Hello world")
                .map(String::length).subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.immediate()).subscribe(len -> {
            System.out.println("got " + len + " @ " + Thread.currentThread().getName());
        });

//        Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("aabbcc");
//            }
//        });


//        Observable.just("str1", "str2", "str3", "str4")
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String t) {
//                        return "[" + t + "]";
//                    }
//                }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted ");
//            }
//
//            @Override
//            public void onNext(String t) {
//                System.out.println("onNext " + t);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//        });
    }
}
