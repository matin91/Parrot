package com.rocklobstre.parrot.dependencyinjection.modules;

import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideSchedulerFactory
    implements Factory<BaseSchedulerProvider> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideSchedulerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public BaseSchedulerProvider get() {
    return Preconditions.checkNotNull(
        module.provideScheduler(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<BaseSchedulerProvider> create(ApplicationModule module) {
    return new ApplicationModule_ProvideSchedulerFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideScheduler()}. */
  public static BaseSchedulerProvider proxyProvideScheduler(ApplicationModule instance) {
    return instance.provideScheduler();
  }
}
