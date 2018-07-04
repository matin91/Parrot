package com.rocklobstre.parrot.dependencyinjection.components;

import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.Vibrator;
import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.remote.RestApi;
import com.rocklobstre.parrot.data.remote.executor.JobExecutor;
import com.rocklobstre.parrot.data.remote.executor.JobExecutor_Factory;
import com.rocklobstre.parrot.data.remote.executor.PostExecutionThread;
import com.rocklobstre.parrot.data.remote.executor.ThreadExecutor;
import com.rocklobstre.parrot.data.remote.executor.UIThread;
import com.rocklobstre.parrot.data.remote.executor.UIThread_Factory;
import com.rocklobstre.parrot.data.remote.repository.AlarmRepository;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAlarmManagerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAlarmSourceFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideAudioManagerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideContextFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideSchedulerFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideSpeakerboxFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideVibratorFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule_ProvideWakeLockFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.DataModule;
import com.rocklobstre.parrot.dependencyinjection.modules.DataModule_ProvideAlarmRepositoryFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.DataModule_ProvidePostExecutionThreadFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.DataModule_ProvideRestApiFactory;
import com.rocklobstre.parrot.dependencyinjection.modules.DataModule_ProvideThreadExecutorFactory;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
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

  private Provider<Speakerbox> provideSpeakerboxProvider;

  private Provider<RestApi> provideRestApiProvider;

  private Provider<AlarmRepository> provideAlarmRepositoryProvider;

  private Provider<JobExecutor> jobExecutorProvider;

  private Provider<ThreadExecutor> provideThreadExecutorProvider;

  private Provider<UIThread> uIThreadProvider;

  private Provider<PostExecutionThread> providePostExecutionThreadProvider;

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

    this.provideSpeakerboxProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideSpeakerboxFactory.create(builder.applicationModule));

    this.provideRestApiProvider =
        DoubleCheck.provider(DataModule_ProvideRestApiFactory.create(builder.dataModule));

    this.provideAlarmRepositoryProvider =
        DoubleCheck.provider(
            DataModule_ProvideAlarmRepositoryFactory.create(
                builder.dataModule, provideRestApiProvider));

    this.jobExecutorProvider = DoubleCheck.provider(JobExecutor_Factory.create());

    this.provideThreadExecutorProvider =
        DoubleCheck.provider(
            DataModule_ProvideThreadExecutorFactory.create(
                builder.dataModule, jobExecutorProvider));

    this.uIThreadProvider = DoubleCheck.provider(UIThread_Factory.create());

    this.providePostExecutionThreadProvider =
        DoubleCheck.provider(
            DataModule_ProvidePostExecutionThreadFactory.create(
                builder.dataModule, uIThreadProvider));
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

  @Override
  public Speakerbox getSpeakerbox() {
    return provideSpeakerboxProvider.get();
  }

  @Override
  public RestApi restApi() {
    return provideRestApiProvider.get();
  }

  @Override
  public AlarmRepository alarmRepository() {
    return provideAlarmRepositoryProvider.get();
  }

  @Override
  public ThreadExecutor threadExecutor() {
    return provideThreadExecutorProvider.get();
  }

  @Override
  public PostExecutionThread postExecutionThread() {
    return providePostExecutionThreadProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private DataModule dataModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (dataModule == null) {
        this.dataModule = new DataModule();
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder dataModule(DataModule dataModule) {
      this.dataModule = Preconditions.checkNotNull(dataModule);
      return this;
    }
  }
}
