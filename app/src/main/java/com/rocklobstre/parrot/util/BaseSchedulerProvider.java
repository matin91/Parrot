package com.rocklobstre.parrot.util;

import io.reactivex.Scheduler;

/**
 * Created by Matin on 05/03/2017.
 */

public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
