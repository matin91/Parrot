package com.rocklobstre.parrot.speaker;

import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpeakerDetailPresenter_Factory implements Factory<SpeakerDetailPresenter> {
  private final Provider<SpeakerDetailContract.View> viewProvider;

  private final Provider<AlarmSource> alarmSourceProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  public SpeakerDetailPresenter_Factory(
      Provider<SpeakerDetailContract.View> viewProvider,
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
  public SpeakerDetailPresenter get() {
    return new SpeakerDetailPresenter(
        viewProvider.get(), alarmSourceProvider.get(), schedulerProvider.get());
  }

  public static Factory<SpeakerDetailPresenter> create(
      Provider<SpeakerDetailContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<BaseSchedulerProvider> schedulerProvider) {
    return new SpeakerDetailPresenter_Factory(viewProvider, alarmSourceProvider, schedulerProvider);
  }
}
