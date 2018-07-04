package com.rocklobstre.parrot.data.alarmservice;

import com.rocklobstre.parrot.data.viewmodel.Alarm;

import io.reactivex.Completable;

/**
 * This interface describes the responsibilities and interactions between
 * Presenters and The ReminderRepository class.
 * Created by Matin on 09/03/2017.
 */

public interface AlarmManager {

    Completable setAlarm(Alarm alarm);

    Completable cancelAlarm(Alarm alarm);

    Completable dismissAlarm();

    Completable startAlarm(Alarm alarm);
}
