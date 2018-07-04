package com.rocklobstre.parrot.alarmdetail;

import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.remote.executor.PostExecutionThread;
import com.rocklobstre.parrot.data.remote.executor.ThreadExecutor;
import com.rocklobstre.parrot.data.remote.repository.AlarmRepository;
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

  private Provider<AlarmManager> alarmManagerProvider;

  private Provider<AlarmRepository> alarmRepositoryProvider;

  private Provider<BaseSchedulerProvider> baseSchedulerProvider;

  private Provider<ThreadExecutor> threadExecutorProvider;

  private Provider<PostExecutionThread> postExecutionThreadProvider;

  private Provider<AlarmDetailPresenter> alarmDetailPresenterProvider;

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

    this.threadExecutorProvider =
        new dagger.internal.Factory<ThreadExecutor>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public ThreadExecutor get() {
            return Preconditions.checkNotNull(
                applicationComponent.threadExecutor(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.postExecutionThreadProvider =
        new dagger.internal.Factory<PostExecutionThread>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public PostExecutionThread get() {
            return Preconditions.checkNotNull(
                applicationComponent.postExecutionThread(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.alarmDetailPresenterProvider =
        AlarmDetailPresenter_Factory.create(
            provideAlarmDetailViewProvider,
            alarmSourceProvider,
            alarmManagerProvider,
            alarmRepositoryProvider,
            baseSchedulerProvider,
            threadExecutorProvider,
            postExecutionThreadProvider);

    this.alarmDetailFragmentMembersInjector =
        AlarmDetailFragment_MembersInjector.create(alarmDetailPresenterProvider);
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
