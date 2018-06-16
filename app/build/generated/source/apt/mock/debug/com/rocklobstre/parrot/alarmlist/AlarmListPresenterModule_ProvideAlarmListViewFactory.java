package com.rocklobstre.parrot.alarmlist;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmListPresenterModule_ProvideAlarmListViewFactory
    implements Factory<AlarmListContract.View> {
  private final AlarmListPresenterModule module;

  public AlarmListPresenterModule_ProvideAlarmListViewFactory(AlarmListPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmListContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAlarmListView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmListContract.View> create(AlarmListPresenterModule module) {
    return new AlarmListPresenterModule_ProvideAlarmListViewFactory(module);
  }

  /** Proxies {@link AlarmListPresenterModule#provideAlarmListView()}. */
  public static AlarmListContract.View proxyProvideAlarmListView(
      AlarmListPresenterModule instance) {
    return instance.provideAlarmListView();
  }
}
