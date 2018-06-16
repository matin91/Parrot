package com.rocklobstre.parrot.dependencyinjection.modules;

import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideAlarmSourceFactory implements Factory<AlarmSource> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideAlarmSourceFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmSource get() {
    return Preconditions.checkNotNull(
        module.provideAlarmSource(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmSource> create(ApplicationModule module) {
    return new ApplicationModule_ProvideAlarmSourceFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideAlarmSource()}. */
  public static AlarmSource proxyProvideAlarmSource(ApplicationModule instance) {
    return instance.provideAlarmSource();
  }
}
