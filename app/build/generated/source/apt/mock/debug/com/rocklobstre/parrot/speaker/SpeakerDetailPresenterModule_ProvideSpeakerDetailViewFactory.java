package com.rocklobstre.parrot.speaker;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpeakerDetailPresenterModule_ProvideSpeakerDetailViewFactory
    implements Factory<SpeakerDetailContract.View> {
  private final SpeakerDetailPresenterModule module;

  public SpeakerDetailPresenterModule_ProvideSpeakerDetailViewFactory(
      SpeakerDetailPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SpeakerDetailContract.View get() {
    return Preconditions.checkNotNull(
        module.provideSpeakerDetailView(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SpeakerDetailContract.View> create(SpeakerDetailPresenterModule module) {
    return new SpeakerDetailPresenterModule_ProvideSpeakerDetailViewFactory(module);
  }

  /** Proxies {@link SpeakerDetailPresenterModule#provideSpeakerDetailView()}. */
  public static SpeakerDetailContract.View proxyProvideSpeakerDetailView(
      SpeakerDetailPresenterModule instance) {
    return instance.provideSpeakerDetailView();
  }
}
