package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.settings.SettingsContract;
import com.rocklobstre.parrot.settings.SettingsPresenter;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingsPresenter_Factory implements Factory<SettingsPresenter> {
  private final Provider<SettingsContract.View> viewProvider;

  public SettingsPresenter_Factory(Provider<SettingsContract.View> viewProvider) {
    assert viewProvider != null;
    this.viewProvider = viewProvider;
  }

  @Override
  public SettingsPresenter get() {
    return new SettingsPresenter(viewProvider.get());
  }

  public static Factory<SettingsPresenter> create(Provider<SettingsContract.View> viewProvider) {
    return new SettingsPresenter_Factory(viewProvider);
  }
}
