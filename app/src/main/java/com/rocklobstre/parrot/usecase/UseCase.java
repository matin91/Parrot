package com.rocklobstre.parrot.usecase;


import io.reactivex.Flowable;


public interface UseCase<T, Params> {

    Flowable<T> runUseCase(Params... params);

}