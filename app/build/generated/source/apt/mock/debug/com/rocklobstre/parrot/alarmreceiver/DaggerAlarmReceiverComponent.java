package com.rocklobstre.parrot.alarmreceiver;

import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
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
public final class DaggerAlarmReceiverComponent implements AlarmReceiverComponent {
  private Provider<AlarmReceiverContract.View> provideAlarmReceiverViewProvider;

  private Provider<AlarmSource> alarmSourceProvider;

  private Provider<AlarmManager> alarmManagerProvider;

  private Provider<BaseSchedulerProvider> baseSchedulerProvider;

  private Provider<AlarmReceiverPresenter> alarmReceiverPresenterProvider;

  private Provider<Speakerbox> getSpeakerboxProvider;

  private MembersInjector<AlarmReceiverFragment> alarmReceiverFragmentMembersInjector;

  private DaggerAlarmReceiverComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideAlarmReceiverViewProvider =
        AlarmReceiverPresenterModule_ProvideAlarmReceiverViewFactory.create(
            builder.alarmReceiverPresenterModule);

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

    this.alarmManagerProvider =
        new dagger.internal.Factory<AlarmManager>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public AlarmManager get() {
            return Preconditions.checkNotNull(
                applicationComponent.alarmManager(),
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

    this.alarmReceiverPresenterProvider =
        AlarmReceiverPresenter_Factory.create(
            provideAlarmReceiverViewProvider,
            alarmSourceProvider,
            alarmManagerProvider,
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

    this.alarmReceiverFragmentMembersInjector =
        AlarmReceiverFragment_MembersInjector.create(
            alarmReceiverPresenterProvider, getSpeakerboxProvider);
  }

  @Override
  public void inject(AlarmReceiverFragment alarmReceiverFragment) {
    alarmReceiverFragmentMembersInjector.injectMembers(alarmReceiverFragment);
  }

  public static final class Builder {
    private AlarmReceiverPresenterModule alarmReceiverPresenterModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public AlarmReceiverComponent build() {
      if (alarmReceiverPresenterModule == null) {
        throw new IllegalStateException(
            AlarmReceiverPresenterModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAlarmReceiverComponent(this);
    }

    public Builder alarmReceiverPresenterModule(
        AlarmReceiverPresenterModule alarmReceiverPresenterModule) {
      this.alarmReceiverPresenterModule = Preconditions.checkNotNull(alarmReceiverPresenterModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
