package com.rocklobstre.parrot.dependencyinjection.modules;

import android.os.Vibrator;

import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideVibratorFactory implements Factory<Vibrator> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideVibratorFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Vibrator get() {
    return Preconditions.checkNotNull(
        module.provideVibrator(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Vibrator> create(ApplicationModule module) {
    return new ApplicationModule_ProvideVibratorFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideVibrator()}. */
  public static Vibrator proxyProvideVibrator(ApplicationModule instance) {
    return instance.provideVibrator();
  }
}
