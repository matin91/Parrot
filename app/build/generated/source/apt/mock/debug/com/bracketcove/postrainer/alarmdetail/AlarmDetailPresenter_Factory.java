package com.rocklobstre.parrot.alarmdetail;

import com.rocklobstre.parrot.alarmdetail.AlarmDetailPresenter;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import com.rocklobstre.parrot.alarmdetail.AlarmDetailContract;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmDetailPresenter_Factory implements Factory<AlarmDetailPresenter> {
  private final Provider<AlarmDetailContract.View> viewProvider;

  private final Provider<AlarmSource> alarmSourceProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  public AlarmDetailPresenter_Factory(
      Provider<AlarmDetailContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    assert viewProvider != null;
    this.viewProvider = viewProvider;
    assert alarmSourceProvider != null;
    this.alarmSourceProvider = alarmSourceProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public AlarmDetailPresenter get() {
    return new AlarmDetailPresenter(
        viewProvider.get(), alarmSourceProvider.get(), schedulerProvider.get());
  }

  public static Factory<AlarmDetailPresenter> create(
      Provider<AlarmDetailContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    return new AlarmDetailPresenter_Factory(viewProvider, alarmSourceProvider, schedulerProvider);
  }
}
