package com.rocklobstre.parrot.dependencyinjection.components;

import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.Vibrator;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAlarmManagerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAlarmSourceFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAudioManagerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideContextFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideSchedulerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideVibratorFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideWakeLockFactory;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;

  private Provider<PowerManager.WakeLock> provideWakeLockProvider;

  private Provider<AudioManager> provideAudioManagerProvider;

  private Provider<Vibrator> provideVibratorProvider;

  private Provider<AlarmManager> provideAlarmManagerProvider;

  private Provider<AlarmSource> provideAlarmSourceProvider;

  private Provider<BaseSchedulerProvider> provideSchedulerProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideContextFactory.create(builder.applicationModule));

    this.provideWakeLockProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideWakeLockFactory.create(builder.applicationModule));

    this.provideAudioManagerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideAudioManagerFactory.create(builder.applicationModule));

    this.provideVibratorProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideVibratorFactory.create(builder.applicationModule));

    this.provideAlarmManagerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideAlarmManagerFactory.create(builder.applicationModule));

    this.provideAlarmSourceProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideAlarmSourceFactory.create(builder.applicationModule));

    this.provideSchedulerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideSchedulerFactory.create(builder.applicationModule));
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  @Override
  public PowerManager.WakeLock wakeLock() {
    return provideWakeLockProvider.get();
  }

  @Override
  public AudioManager audioManager() {
    return provideAudioManagerProvider.get();
  }

  @Override
  public Vibrator vibrator() {
    return provideVibratorProvider.get();
  }

  @Override
  public AlarmManager alarmManager() {
    return provideAlarmManagerProvider.get();
  }

  @Override
  public AlarmSource alarmSource() {
    return provideAlarmSourceProvider.get();
  }

  @Override
  public BaseSchedulerProvider baseSchedulerProvider() {
    return provideSchedulerProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
