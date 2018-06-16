package com.rocklobstre.parrot.dependencyinjection.modules;

import android.os.PowerManager;

import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideWakeLockFactory
    implements Factory<PowerManager.WakeLock> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideWakeLockFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public PowerManager.WakeLock get() {
    return Preconditions.checkNotNull(
        module.provideWakeLock(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PowerManager.WakeLock> create(ApplicationModule module) {
    return new ApplicationModule_ProvideWakeLockFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideWakeLock()}. */
  public static PowerManager.WakeLock proxyProvideWakeLock(ApplicationModule instance) {
    return instance.provideWakeLock();
  }
}
