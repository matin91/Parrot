package com.rocklobstre.parrot.alarmdetail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmDetailPresenterModule_ProvideAlarmDetailViewFactory
    implements Factory<AlarmDetailContract.View> {
  private final AlarmDetailPresenterModule module;

  public AlarmDetailPresenterModule_ProvideAlarmDetailViewFactory(
      AlarmDetailPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmDetailContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAlarmDetailView(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmDetailContract.View> create(AlarmDetailPresenterModule module) {
    return new AlarmDetailPresenterModule_ProvideAlarmDetailViewFactory(module);
  }

  /** Proxies {@link AlarmDetailPresenterModule#provideAlarmDetailView()}. */
  public static AlarmDetailContract.View proxyProvideAlarmDetailView(
      AlarmDetailPresenterModule instance) {
    return instance.provideAlarmDetailView();
  }
}
