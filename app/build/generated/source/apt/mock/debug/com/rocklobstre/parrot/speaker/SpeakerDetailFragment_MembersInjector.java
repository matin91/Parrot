package com.rocklobstre.parrot.speaker;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpeakerDetailFragment_MembersInjector
    implements MembersInjector<SpeakerDetailFragment> {
  private final Provider<SpeakerDetailPresenter> presenterProvider;

  public SpeakerDetailFragment_MembersInjector(Provider<SpeakerDetailPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<SpeakerDetailFragment> create(
      Provider<SpeakerDetailPresenter> presenterProvider) {
    return new SpeakerDetailFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(SpeakerDetailFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      SpeakerDetailFragment instance, Provider<SpeakerDetailPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
