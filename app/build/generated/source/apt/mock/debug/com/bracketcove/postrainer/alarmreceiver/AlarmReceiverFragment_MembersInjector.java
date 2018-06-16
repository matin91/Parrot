package com.rocklobstre.parrot.alarmreceiver;

import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverFragment;
import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverPresenter;

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

  public AlarmReceiverFragment_MembersInjector(Provider<AlarmReceiverPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<AlarmReceiverFragment> create(
      Provider<AlarmReceiverPresenter> presenterProvider) {
    return new AlarmReceiverFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(AlarmReceiverFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      AlarmReceiverFragment instance, Provider<AlarmReceiverPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
