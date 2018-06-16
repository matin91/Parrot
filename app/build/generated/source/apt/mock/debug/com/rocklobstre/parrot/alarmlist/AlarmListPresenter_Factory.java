package com.rocklobstre.parrot.alarmlist;

import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmListPresenter_Factory implements Factory<AlarmListPresenter> {
  private final Provider<AlarmListContract.View> viewProvider;

  private final Provider<AlarmSource> alarmSourceProvider;

  private final Provider<AlarmManager> alarmManagerProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  public AlarmListPresenter_Factory(
      Provider<AlarmListContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    assert viewProvider != null;
    this.viewProvider = viewProvider;
    assert alarmSourceProvider != null;
    this.alarmSourceProvider = alarmSourceProvider;
    assert alarmManagerProvider != null;
    this.alarmManagerProvider = alarmManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public AlarmListPresenter get() {
    return new AlarmListPresenter(
        viewProvider.get(),
        alarmSourceProvider.get(),
        alarmManagerProvider.get(),
        schedulerProvider.get());
  }

  public static Factory<AlarmListPresenter> create(
      Provider<AlarmListContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    return new AlarmListPresenter_Factory(
        viewProvider, alarmSourceProvider, alarmManagerProvider, schedulerProvider);
  }
}
