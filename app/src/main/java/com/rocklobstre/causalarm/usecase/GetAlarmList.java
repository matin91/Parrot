package com.rocklobstre.causalarm.usecase;

import com.rocklobstre.causalarm.data.alarmdatabase.AlarmSource;
import com.rocklobstre.causalarm.data.viewmodel.Alarm;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by R_KAY on 5/23/2017.
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
