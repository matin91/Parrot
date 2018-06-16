package com.rocklobstre.parrot.dependencyinjection.modules;

import android.media.MediaPlayer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideMediaPlayerFactory implements Factory<MediaPlayer> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideMediaPlayerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MediaPlayer get() {
    return Preconditions.checkNotNull(
        module.provideMediaPlayer(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MediaPlayer> create(ApplicationModule module) {
    return new ApplicationModule_ProvideMediaPlayerFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideMediaPlayer()}. */
  public static MediaPlayer proxyProvideMediaPlayer(ApplicationModule instance) {
    return instance.provideMediaPlayer();
  }
}
