package com.rocklobstre.parrot.usecase.subscriber;

import io.reactivex.observers.DisposableObserver;

public class BaseSubscriber<T> extends DisposableObserver<T> {

    @Override public void onComplete() {
    }

    @Override public void onError(Throwable e) {
    }

    @Override public void onNext(T t) {
    }
}