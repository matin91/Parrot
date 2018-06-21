package com.rocklobstre.parrot.data.retrofit;

import com.rocklobstre.parrot.data.viewmodel.Reason;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by Matin on 18-Oct-17.
 */

public interface RestApi {

    String URL_BASE = "https://my-json-server.typicode.com/RockLobstre/Parrot-JSON/";

    @GET("/reasons")
    Observable<Response<List<Reason>>> getReminderReasons();
}
