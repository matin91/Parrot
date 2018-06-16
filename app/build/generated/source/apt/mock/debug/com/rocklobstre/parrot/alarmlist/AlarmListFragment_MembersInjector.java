package com.rocklobstre.parrot.alarmlist;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmListFragment_MembersInjector implements MembersInjector<AlarmListFragment> {
  private final Provider<AlarmListPresenter> presenterProvider;

  public AlarmListFragment_MembersInjector(Provider<AlarmListPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<AlarmListFragment> create(
      Provider<AlarmListPresenter> presenterProvider) {
    return new AlarmListFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(AlarmListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      AlarmListFragment instance, Provider<AlarmListPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
