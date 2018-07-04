package com.rocklobstre.parrot.usecase;

import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Matin on 5/23/2017.
 */

public class GetAlarmList implements UseCase<List<Alarm>, Void> {

    private final AlarmSource alarmSource;

    public GetAlarmList(AlarmSource alarmSource) {
        this.alarmSource = alarmSource;
    }

    @Override
    public Flowable<List<Alarm>> runUseCase(Void... params) {
        return alarmSource.getAlarms();
    }
}
