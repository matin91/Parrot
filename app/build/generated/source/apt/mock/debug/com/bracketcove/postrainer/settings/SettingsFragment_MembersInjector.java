package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.settings.SettingsFragment;
import com.rocklobstre.parrot.settings.SettingsPresenter;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingsFragment_MembersInjector implements MembersInjector<SettingsFragment> {
  private final Provider<SettingsPresenter> settingsPresenterProvider;

  public SettingsFragment_MembersInjector(Provider<SettingsPresenter> settingsPresenterProvider) {
    assert settingsPresenterProvider != null;
    this.settingsPresenterProvider = settingsPresenterProvider;
  }

  public static MembersInjector<SettingsFragment> create(
      Provider<SettingsPresenter> settingsPresenterProvider) {
    return new SettingsFragment_MembersInjector(settingsPresenterProvider);
  }

  @Override
  public void injectMembers(SettingsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.settingsPresenter = settingsPresenterProvider.get();
  }

  public static void injectSettingsPresenter(
      SettingsFragment instance, Provider<SettingsPresenter> settingsPresenterProvider) {
    instance.settingsPresenter = settingsPresenterProvider.get();
  }
}
