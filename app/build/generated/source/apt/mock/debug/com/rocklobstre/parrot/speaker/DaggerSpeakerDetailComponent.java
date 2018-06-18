package com.rocklobstre.parrot.speaker;

import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSpeakerDetailComponent implements SpeakerDetailComponent {
  private Provider<SpeakerDetailContract.View> provideSpeakerDetailViewProvider;

  private Provider<AlarmSource> alarmSourceProvider;

  private Provider<BaseSchedulerProvider> baseSchedulerProvider;

  private Provider<SpeakerDetailPresenter> speakerDetailPresenterProvider;

  private MembersInjector<SpeakerDetailFragment> speakerDetailFragmentMembersInjector;

  private DaggerSpeakerDetailComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideSpeakerDetailViewProvider =
        SpeakerDetailPresenterModule_ProvideSpeakerDetailViewFactory.create(
            builder.speakerDetailPresenterModule);

    this.alarmSourceProvider =
        new dagger.internal.Factory<AlarmSource>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public AlarmSource get() {
            return Preconditions.checkNotNull(
                applicationComponent.alarmSource(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.baseSchedulerProvider =
        new dagger.internal.Factory<BaseSchedulerProvider>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public BaseSchedulerProvider get() {
            return Preconditions.checkNotNull(
                applicationComponent.baseSchedulerProvider(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.speakerDetailPresenterProvider =
        SpeakerDetailPresenter_Factory.create(
            provideSpeakerDetailViewProvider, alarmSourceProvider, baseSchedulerProvider);

    this.speakerDetailFragmentMembersInjector =
        SpeakerDetailFragment_MembersInjector.create(speakerDetailPresenterProvider);
  }

  @Override
  public void inject(SpeakerDetailFragment alarmDetailFragment) {
    speakerDetailFragmentMembersInjector.injectMembers(alarmDetailFragment);
  }

  public static final class Builder {
    private SpeakerDetailPresenterModule speakerDetailPresenterModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public SpeakerDetailComponent build() {
      if (speakerDetailPresenterModule == null) {
        throw new IllegalStateException(
            SpeakerDetailPresenterModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSpeakerDetailComponent(this);
    }

    public Builder speakerDetailPresenterModule(
        SpeakerDetailPresenterModule speakerDetailPresenterModule) {
      this.speakerDetailPresenterModule = Preconditions.checkNotNull(speakerDetailPresenterModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
