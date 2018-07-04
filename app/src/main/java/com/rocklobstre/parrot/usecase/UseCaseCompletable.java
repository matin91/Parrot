package com.rocklobstre.parrot.usecase;

import io.reactivex.Completable;

/**
 * Created by Matin on 7/17/2017.
 */

public interface UseCaseCompletable<Params> {
        Completable runUseCase(Params... params);
}
