package com.rocklobstre.causalarm.usecase;

import com.rocklobstre.causalarm.data.alarmdatabase.AlarmSource;
import com.rocklobstre.causalarm.data.viewmodel.Alarm;

import io.reactivex.Completable;

/**
 * Created by R_KAY on 5/23/2017.
 */

public class DeleteAlarm implements UseCaseCompletable<Alarm> {

    private final AlarmSource alarmSource;

    public DeleteAlarm(AlarmSource alarmSource) {
        this.alarmSource = alarmSource;
    }

    @Override
    public Completable runUseCase(Alarm... params) {
        return alarmSource.deleteAlarm(params[0]);
    }

}
