package com.rocklobstre.parrot.alarmdetail;

import com.mapzen.speakerbox.Speakerbox;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmDetailFragment_MembersInjector
    implements MembersInjector<AlarmDetailFragment> {
  private final Provider<AlarmDetailPresenter> presenterProvider;

  private final Provider<Speakerbox> speakerboxProvider;

  public AlarmDetailFragment_MembersInjector(
      Provider<AlarmDetailPresenter> presenterProvider, Provider<Speakerbox> speakerboxProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert speakerboxProvider != null;
    this.speakerboxProvider = speakerboxProvider;
  }

  public static MembersInjector<AlarmDetailFragment> create(
      Provider<AlarmDetailPresenter> presenterProvider, Provider<Speakerbox> speakerboxProvider) {
    return new AlarmDetailFragment_MembersInjector(presenterProvider, speakerboxProvider);
  }

  @Override
  public void injectMembers(AlarmDetailFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.speakerbox = speakerboxProvider.get();
  }

  public static void injectPresenter(
      AlarmDetailFragment instance, Provider<AlarmDetailPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectSpeakerbox(
      AlarmDetailFragment instance, Provider<Speakerbox> speakerboxProvider) {
    instance.speakerbox = speakerboxProvider.get();
  }
}
