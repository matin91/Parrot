package com.rocklobstre.parrot.data.retrofit.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
