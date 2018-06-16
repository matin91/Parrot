package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSettingsComponent implements SettingsComponent {
  private Provider<SettingsContract.View> provideSettingsViewProvider;

  private Provider<SettingsPresenter> settingsPresenterProvider;

  private MembersInjector<SettingsFragment> settingsFragmentMembersInjector;

  private DaggerSettingsComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideSettingsViewProvider =
        SettingsPresenterModule_ProvideSettingsViewFactory.create(builder.settingsPresenterModule);

    this.settingsPresenterProvider = SettingsPresenter_Factory.create(provideSettingsViewProvider);

    this.settingsFragmentMembersInjector =
        SettingsFragment_MembersInjector.create(settingsPresenterProvider);
  }

  @Override
  public void inject(SettingsFragment settingsFragment) {
    settingsFragmentMembersInjector.injectMembers(settingsFragment);
  }

  public static final class Builder {
    private SettingsPresenterModule settingsPresenterModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public SettingsComponent build() {
      if (settingsPresenterModule == null) {
        throw new IllegalStateException(
            SettingsPresenterModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSettingsComponent(this);
    }

    public Builder settingsPresenterModule(SettingsPresenterModule settingsPresenterModule) {
      this.settingsPresenterModule = Preconditions.checkNotNull(settingsPresenterModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
