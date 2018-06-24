package com.rocklobstre.parrot.data.remote.executor;

import com.rocklobstre.parrot.dependencyinjection.scope.MainApplicationScope;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@MainApplicationScope
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

}