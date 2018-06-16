package com.rocklobstre.parrot.dependencyinjection.modules;

import android.app.AlarmManager;

import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideAndroidAlarmManagerFactory
    implements Factory<AlarmManager> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideAndroidAlarmManagerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmManager get() {
    return Preconditions.checkNotNull(
        module.provideAndroidAlarmManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmManager> create(ApplicationModule module) {
    return new ApplicationModule_ProvideAndroidAlarmManagerFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideAndroidAlarmManager()}. */
  public static AlarmManager proxyProvideAndroidAlarmManager(ApplicationModule instance) {
    return instance.provideAndroidAlarmManager();
  }
}
