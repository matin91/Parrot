package com.rocklobstre.parrot.usecase;


import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import io.reactivex.Completable;

/**
 * Created by Matin on 5/23/2017.
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
