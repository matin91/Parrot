package com.rocklobstre.parrot.alarmlist;

import com.rocklobstre.parrot.alarmlist.AlarmListPresenter;
import com.rocklobstre.parrot.alarmlist.AlarmListPresenterModule;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.alarmlist.AlarmListComponent;
import com.rocklobstre.parrot.alarmlist.AlarmListContract;
import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import com.rocklobstre.parrot.alarmlist.AlarmListFragment;

import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAlarmListComponent implements AlarmListComponent {
  private Provider<AlarmListContract.View> provideAlarmListViewProvider;

  private Provider<AlarmSource> alarmSourceProvider;

  private Provider<AlarmManager> alarmManagerProvider;

  private Provider<BaseSchedulerProvider> baseSchedulerProvider;

  private Provider<AlarmListPresenter> alarmListPresenterProvider;

  private MembersInjector<AlarmListFragment> alarmListFragmentMembersInjector;

  private DaggerAlarmListComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideAlarmListViewProvider =
        AlarmListPresenterModule_ProvideAlarmListViewFactory.create(
            builder.alarmListPresenterModule);

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

    this.alarmListPresenterProvider =
        AlarmListPresenter_Factory.create(
            provideAlarmListViewProvider,
            alarmSourceProvider,
            alarmManagerProvider,
            baseSchedulerProvider);

    this.alarmListFragmentMembersInjector =
        AlarmListFragment_MembersInjector.create(alarmListPresenterProvider);
  }

  @Override
  public void inject(AlarmListFragment alarmListFragment) {
    alarmListFragmentMembersInjector.injectMembers(alarmListFragment);
  }

  public static final class Builder {
    private AlarmListPresenterModule alarmListPresenterModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public AlarmListComponent build() {
      if (alarmListPresenterModule == null) {
        throw new IllegalStateException(
            AlarmListPresenterModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAlarmListComponent(this);
    }

    public Builder alarmListPresenterModule(AlarmListPresenterModule alarmListPresenterModule) {
      this.alarmListPresenterModule = Preconditions.checkNotNull(alarmListPresenterModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
