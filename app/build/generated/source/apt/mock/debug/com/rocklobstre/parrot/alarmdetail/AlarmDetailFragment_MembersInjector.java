package com.rocklobstre.parrot.alarmdetail;

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

  public AlarmDetailFragment_MembersInjector(Provider<AlarmDetailPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<AlarmDetailFragment> create(
      Provider<AlarmDetailPresenter> presenterProvider) {
    return new AlarmDetailFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(AlarmDetailFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      AlarmDetailFragment instance, Provider<AlarmDetailPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
