package com.rocklobstre.parrot.dependencyinjection.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.rocklobstre.parrot.data.remote.RestApi;
import com.rocklobstre.parrot.data.remote.executor.JobExecutor;
import com.rocklobstre.parrot.data.remote.executor.PostExecutionThread;
import com.rocklobstre.parrot.data.remote.executor.ThreadExecutor;
import com.rocklobstre.parrot.data.remote.executor.UIThread;
import com.rocklobstre.parrot.data.remote.interceptor.HttpInterceptor;
import com.rocklobstre.parrot.data.remote.repository.AlarmRepository;
import com.rocklobstre.parrot.dependencyinjection.scope.MainApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is a Module. It provides dependencies via @Provides annotated methods below.
 * Module's are designed to be partitioned in a way that makes sense.
 * Created by Ryan on 10/03/2017.
 */
@Module
public final class DataModule {

    @Provides
    @MainApplicationScope
    RestApi provideRestApi() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpInterceptor())
                .build();

        GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create());

        return new Retrofit.Builder()
                .baseUrl(RestApi.URL_BASE)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(RestApi.class);
    }

    @Provides
    @MainApplicationScope
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @MainApplicationScope
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


    @Provides
    @MainApplicationScope
    AlarmRepository provideAlarmRepository(RestApi restApi) {
        return new AlarmRepository(restApi);
    }

}
