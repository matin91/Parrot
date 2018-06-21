package com.rocklobstre.parrot.alarmdetail;

import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.retrofit.repository.AlarmRepository;
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
public final class DaggerAlarmDetailComponent implements AlarmDetailComponent {
  private Provider<AlarmDetailContract.View> provideAlarmDetailViewProvider;

  private Provider<AlarmSource> alarmSourceProvider;

  private Provider<AlarmRepository> alarmRepositoryProvider;

  private Provider<BaseSchedulerProvider> baseSchedulerProvider;

  private Provider<AlarmDetailPresenter> alarmDetailPresenterProvider;

  private Provider<Speakerbox> getSpeakerboxProvider;

  private MembersInjector<AlarmDetailFragment> alarmDetailFragmentMembersInjector;

  private DaggerAlarmDetailComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideAlarmDetailViewProvider =
        AlarmDetailPresenterModule_ProvideAlarmDetailViewFactory.create(
            builder.alarmDetailPresenterModule);

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

    this.alarmRepositoryProvider =
        new dagger.internal.Factory<AlarmRepository>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public AlarmRepository get() {
            return Preconditions.checkNotNull(
                applicationComponent.alarmRepository(),
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

    this.alarmDetailPresenterProvider =
        AlarmDetailPresenter_Factory.create(
            provideAlarmDetailViewProvider,
            alarmSourceProvider,
            alarmRepositoryProvider,
            baseSchedulerProvider);

    this.getSpeakerboxProvider =
        new dagger.internal.Factory<Speakerbox>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Speakerbox get() {
            return Preconditions.checkNotNull(
                applicationComponent.getSpeakerbox(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.alarmDetailFragmentMembersInjector =
        AlarmDetailFragment_MembersInjector.create(
            alarmDetailPresenterProvider, getSpeakerboxProvider);
  }

  @Override
  public void inject(AlarmDetailFragment alarmDetailFragment) {
    alarmDetailFragmentMembersInjector.injectMembers(alarmDetailFragment);
  }

  public static final class Builder {
    private AlarmDetailPresenterModule alarmDetailPresenterModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public AlarmDetailComponent build() {
      if (alarmDetailPresenterModule == null) {
        throw new IllegalStateException(
            AlarmDetailPresenterModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAlarmDetailComponent(this);
    }

    public Builder alarmDetailPresenterModule(
        AlarmDetailPresenterModule alarmDetailPresenterModule) {
      this.alarmDetailPresenterModule = Preconditions.checkNotNull(alarmDetailPresenterModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
