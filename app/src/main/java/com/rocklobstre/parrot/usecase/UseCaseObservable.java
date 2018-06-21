package com.rocklobstre.parrot.usecase;

import io.reactivex.Observable;

/**
 * Created by R_KAY on 7/17/2017.
 */

public interface UseCaseObservable<T, Params> {

        Observable<T> runUseCase(Params... params);

}