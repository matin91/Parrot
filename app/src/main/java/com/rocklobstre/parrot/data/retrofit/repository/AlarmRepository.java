package com.rocklobstre.parrot.data.retrofit.repository;

import com.rocklobstre.parrot.data.retrofit.RestApi;
import com.rocklobstre.parrot.data.viewmodel.Reason;
import com.rocklobstre.parrot.dependencyinjection.scope.MainApplicationScope;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@MainApplicationScope
public class AlarmRepository extends RestApiRepository implements DataRepository {

    private final RestApi restApi;

    @Inject
    public AlarmRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<List<Reason>> getReminderReasons() {
        return this.restApi.getReminderReasons()
                .map(listResponse -> {
                    handleResponseError(listResponse);
                    return listResponse.body();
                });
    }
}
