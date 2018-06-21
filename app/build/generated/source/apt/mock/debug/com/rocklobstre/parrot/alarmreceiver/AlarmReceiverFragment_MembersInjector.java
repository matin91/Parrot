package com.rocklobstre.parrot.alarmreceiver;

import com.mapzen.speakerbox.Speakerbox;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmReceiverFragment_MembersInjector
    implements MembersInjector<AlarmReceiverFragment> {
  private final Provider<AlarmReceiverPresenter> presenterProvider;

  private final Provider<Speakerbox> speakerboxProvider;

  public AlarmReceiverFragment_MembersInjector(
      Provider<AlarmReceiverPresenter> presenterProvider, Provider<Speakerbox> speakerboxProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert speakerboxProvider != null;
    this.speakerboxProvider = speakerboxProvider;
  }

  public static MembersInjector<AlarmReceiverFragment> create(
      Provider<AlarmReceiverPresenter> presenterProvider, Provider<Speakerbox> speakerboxProvider) {
    return new AlarmReceiverFragment_MembersInjector(presenterProvider, speakerboxProvider);
  }

  @Override
  public void injectMembers(AlarmReceiverFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.speakerbox = speakerboxProvider.get();
  }

  public static void injectPresenter(
      AlarmReceiverFragment instance, Provider<AlarmReceiverPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectSpeakerbox(
      AlarmReceiverFragment instance, Provider<Speakerbox> speakerboxProvider) {
    instance.speakerbox = speakerboxProvider.get();
  }
}
