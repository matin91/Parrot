package com.rocklobstre.parrot.speaker;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpeakerDetailPresenterModule_ProvideAlarmDetailViewFactory
    implements Factory<SpeakerDetailContract.View> {
  private final SpeakerDetailPresenterModule module;

  public SpeakerDetailPresenterModule_ProvideAlarmDetailViewFactory(
      SpeakerDetailPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SpeakerDetailContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAlarmDetailView(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SpeakerDetailContract.View> create(SpeakerDetailPresenterModule module) {
    return new SpeakerDetailPresenterModule_ProvideAlarmDetailViewFactory(module);
  }

  /** Proxies {@link SpeakerDetailPresenterModule#provideAlarmDetailView()}. */
  public static SpeakerDetailContract.View proxyProvideAlarmDetailView(
      SpeakerDetailPresenterModule instance) {
    return instance.provideAlarmDetailView();
  }
}
