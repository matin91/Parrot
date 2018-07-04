package com.rocklobstre.parrot.usecase;

import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import io.reactivex.Completable;

/**
 * Created by Matin on 5/23/2017.
 */

public class UpdateOrCreateAlarm implements UseCaseCompletable<Alarm> {

    private final AlarmSource alarmSource;

    public UpdateOrCreateAlarm(AlarmSource alarmSource) {
        this.alarmSource = alarmSource;
    }

    @Override
    public Completable runUseCase(Alarm... params) {
        return alarmSource.updateAlarm(params[0]);
    }
}
