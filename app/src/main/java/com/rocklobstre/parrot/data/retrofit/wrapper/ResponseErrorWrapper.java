package com.rocklobstre.parrot.data.retrofit.wrapper;

import com.rocklobstre.parrot.data.retrofit.error.ResponseErrorEntity;

public class ResponseErrorWrapper {

    private ResponseErrorEntity error;

    public ResponseErrorWrapper(ResponseErrorEntity error) {
        this.error = error;
    }

    public ResponseErrorEntity getError() {
        return error;
    }

    public void setError(ResponseErrorEntity error) {
        this.error = error;
    }
}
