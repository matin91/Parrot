package com.rocklobstre.parrot.data.remote.repository;

import com.rocklobstre.parrot.data.viewmodel.Reason;

import java.util.List;

import io.reactivex.Observable;

public interface DataRepository {
    Observable<List<Reason>> getReminderReasons();
}
