package com.rocklobstre.parrot.alarmreceiver;

import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverContract;
import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverPresenter;
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
public final class AlarmReceiverPresenter_Factory implements Factory<AlarmReceiverPresenter> {
  private final Provider<AlarmReceiverContract.View> viewProvider;

  private final Provider<AlarmSource> alarmSourceProvider;

  private final Provider<AlarmManager> alarmManagerProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  public AlarmReceiverPresenter_Factory(
      Provider<AlarmReceiverContract.View> viewProvider,
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
  public AlarmReceiverPresenter get() {
    return new AlarmReceiverPresenter(
        viewProvider.get(),
        alarmSourceProvider.get(),
        alarmManagerProvider.get(),
        schedulerProvider.get());
  }

  public static Factory<AlarmReceiverPresenter> create(
      Provider<AlarmReceiverContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    return new AlarmReceiverPresenter_Factory(
        viewProvider, alarmSourceProvider, alarmManagerProvider, schedulerProvider);
  }
}
