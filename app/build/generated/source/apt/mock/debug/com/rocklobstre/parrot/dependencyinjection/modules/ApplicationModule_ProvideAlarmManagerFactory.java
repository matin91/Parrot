package com.rocklobstre.parrot.dependencyinjection.modules;

import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideAlarmManagerFactory implements Factory<AlarmManager> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideAlarmManagerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmManager get() {
    return Preconditions.checkNotNull(
        module.provideAlarmManager(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmManager> create(ApplicationModule module) {
    return new ApplicationModule_ProvideAlarmManagerFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideAlarmManager()}. */
  public static AlarmManager proxyProvideAlarmManager(ApplicationModule instance) {
    return instance.provideAlarmManager();
  }
}
