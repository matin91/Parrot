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
import com.rocklobstre.parrot.ParrotApplication;
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
public final class ApplicationModule {
    private final Context applicationContext;
    private final PowerManager.WakeLock wakeLock;
    private final Vibrator vibrator;
    private final AudioManager audioManager;
    private final AlarmManager alarmManager;
    private final MediaPlayer mediaPlayer;


    //This objects are necessary for creation of other objects within this Module, hence making them
    //variables
    public ApplicationModule(Context application) {
        this.applicationContext = application;
        this.wakeLock = ((PowerManager) applicationContext
                .getSystemService(POWER_SERVICE))
                .newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Alarm");
        this.audioManager = ((AudioManager) applicationContext.getSystemService(Context.AUDIO_SERVICE));
        this.vibrator = ((Vibrator) applicationContext.getSystemService(Context.VIBRATOR_SERVICE));
        this.alarmManager = ((AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE));
        this.mediaPlayer = MediaPlayer.create(application, Settings.System.DEFAULT_ALARM_ALERT_URI);
    }

    @Provides
    @MainApplicationScope
    Context provideContext() {
        return applicationContext;
    }

    @MainApplicationScope
    @Provides
    PowerManager.WakeLock provideWakeLock() {
        return wakeLock;
    }

    @MainApplicationScope
    @Provides
    AudioManager provideAudioManager() {
        return audioManager;
    }

    @MainApplicationScope
    @Provides
    MediaPlayer provideMediaPlayer() {
        return mediaPlayer;
    }

    @MainApplicationScope
    @Provides
    Vibrator provideVibrator() {
        return vibrator;
    }

    @MainApplicationScope
    @Provides
    AlarmManager provideAndroidAlarmManager() {
        return alarmManager;
    }

    @MainApplicationScope
    @Provides
    BaseSchedulerProvider provideScheduler() {
        return new SchedulerProvider();
    }

    @MainApplicationScope
    @Provides
    com.rocklobstre.parrot.data.alarmservice.AlarmManager provideAlarmManager() {
        return new AlarmService(
                wakeLock,
                mediaPlayer,
                audioManager,
                vibrator,
                alarmManager,
                applicationContext
        );
    }

    @MainApplicationScope
    @Provides
    AlarmSource provideAlarmSource() {
        return new AlarmDatabase();
    }

    @MainApplicationScope
    @Provides
    Speakerbox provideSpeakerbox(){
        return new Speakerbox(ParrotApplication.getInstance());
    }

}
