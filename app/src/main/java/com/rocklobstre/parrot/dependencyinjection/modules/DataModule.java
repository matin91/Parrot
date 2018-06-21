package com.rocklobstre.parrot.dependencyinjection.modules;

import android.app.AlarmManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.PostrainerApplication;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmDatabase;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.alarmservice.AlarmService;
import com.rocklobstre.parrot.data.retrofit.RestApi;
import com.rocklobstre.parrot.data.retrofit.interceptor.HttpInterceptor;
import com.rocklobstre.parrot.data.retrofit.repository.AlarmRepository;
import com.rocklobstre.parrot.dependencyinjection.scope.MainApplicationScope;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import com.rocklobstre.parrot.util.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.POWER_SERVICE;

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
    AlarmRepository provideAlarmRepository(RestApi restApi) {
        return new AlarmRepository(restApi);
    }

}
