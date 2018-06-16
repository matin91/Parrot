package com.rocklobstre.parrot.data.alarmservice;

import android.app.AlarmManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.os.Vibrator;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmService_Factory implements Factory<AlarmService> {
  private final Provider<PowerManager.WakeLock> wakeLockProvider;

  private final Provider<MediaPlayer> mediaPlayerProvider;

  private final Provider<AudioManager> audioManagerProvider;

  private final Provider<Vibrator> vibeProvider;

  private final Provider<AlarmManager> alarmManagerProvider;

  private final Provider<Context> applicationContextProvider;

  public AlarmService_Factory(
      Provider<PowerManager.WakeLock> wakeLockProvider,
      Provider<MediaPlayer> mediaPlayerProvider,
      Provider<AudioManager> audioManagerProvider,
      Provider<Vibrator> vibeProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<Context> applicationContextProvider) {
    assert wakeLockProvider != null;
    this.wakeLockProvider = wakeLockProvider;
    assert mediaPlayerProvider != null;
    this.mediaPlayerProvider = mediaPlayerProvider;
    assert audioManagerProvider != null;
    this.audioManagerProvider = audioManagerProvider;
    assert vibeProvider != null;
    this.vibeProvider = vibeProvider;
    assert alarmManagerProvider != null;
    this.alarmManagerProvider = alarmManagerProvider;
    assert applicationContextProvider != null;
    this.applicationContextProvider = applicationContextProvider;
  }

  @Override
  public AlarmService get() {
    return new AlarmService(
        wakeLockProvider.get(),
        mediaPlayerProvider.get(),
        audioManagerProvider.get(),
        vibeProvider.get(),
        alarmManagerProvider.get(),
        applicationContextProvider.get());
  }

  public static Factory<AlarmService> create(
      Provider<PowerManager.WakeLock> wakeLockProvider,
      Provider<MediaPlayer> mediaPlayerProvider,
      Provider<AudioManager> audioManagerProvider,
      Provider<Vibrator> vibeProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<Context> applicationContextProvider) {
    return new AlarmService_Factory(
        wakeLockProvider,
        mediaPlayerProvider,
        audioManagerProvider,
        vibeProvider,
        alarmManagerProvider,
        applicationContextProvider);
  }
}
