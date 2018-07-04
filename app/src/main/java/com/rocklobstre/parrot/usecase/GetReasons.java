package com.rocklobstre.parrot.usecase;

import com.rocklobstre.parrot.data.remote.repository.AlarmRepository;
import com.rocklobstre.parrot.data.viewmodel.Reason;

import java.util.List;

import io.reactivex.Observable;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Retrieve a specific Alarm from the Database, according to a reminderId which is passed in to
 * this Use Case.
 * - If a Alarm is found, return it to the Presenter.
 * - If no Alarm is found, throw NoReminderFoundException
 * Created by Matin on 5/23/2017.
 */

public class GetReasons implements UseCaseObservable<List<Reason>, String> {

    private AlarmRepository alarmRepository;

    public GetReasons(AlarmRepository alarmRepository) {
        this.alarmRepository = alarmRepository;
    }

    @Override
    public Observable<List<Reason>> runUseCase(String... params) {
        return this.alarmRepository.getReminderReasons();
    }

}
