package com.rocklobstre.causalarm.usecase;


import com.rocklobstre.causalarm.data.alarmservice.AlarmManager;
import com.rocklobstre.causalarm.data.viewmodel.Alarm;

import io.reactivex.Completable;

/**
 * Created by R_KAY on 5/23/2017.
 */

public class CancelAlarm implements UseCaseCompletable<Alarm> {

    private final AlarmManager alarmManager;

    public CancelAlarm(AlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }

    @Override
    public Completable runUseCase(Alarm... params) {
        return alarmManager.cancelAlarm(params[0]);
    }
}
