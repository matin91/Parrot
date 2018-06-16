package com.rocklobstre.parrot.dependencyinjection.modules;

import android.media.AudioManager;

import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideAudioManagerFactory implements Factory<AudioManager> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideAudioManagerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AudioManager get() {
    return Preconditions.checkNotNull(
        module.provideAudioManager(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AudioManager> create(ApplicationModule module) {
    return new ApplicationModule_ProvideAudioManagerFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideAudioManager()}. */
  public static AudioManager proxyProvideAudioManager(ApplicationModule instance) {
    return instance.provideAudioManager();
  }
}
