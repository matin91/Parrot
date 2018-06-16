package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.settings.SettingsContract;
import com.rocklobstre.parrot.settings.SettingsPresenterModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingsPresenterModule_ProvideSettingsViewFactory
    implements Factory<SettingsContract.View> {
  private final SettingsPresenterModule module;

  public SettingsPresenterModule_ProvideSettingsViewFactory(SettingsPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SettingsContract.View get() {
    return Preconditions.checkNotNull(
        module.provideSettingsView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SettingsContract.View> create(SettingsPresenterModule module) {
    return new SettingsPresenterModule_ProvideSettingsViewFactory(module);
  }

  /** Proxies {@link SettingsPresenterModule#provideSettingsView()}. */
  public static SettingsContract.View proxyProvideSettingsView(SettingsPresenterModule instance) {
    return instance.provideSettingsView();
  }
}
