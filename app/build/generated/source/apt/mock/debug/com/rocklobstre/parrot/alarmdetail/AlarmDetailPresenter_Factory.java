package com.rocklobstre.parrot.alarmdetail;

import com.rocklobstre.parrot.data.alarmservice.AlarmManager;
import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.remote.executor.PostExecutionThread;
import com.rocklobstre.parrot.data.remote.executor.ThreadExecutor;
import com.rocklobstre.parrot.data.remote.repository.AlarmRepository;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmDetailPresenter_Factory implements Factory<AlarmDetailPresenter> {
  private final Provider<AlarmDetailContract.View> viewProvider;

  private final Provider<AlarmSource> alarmSourceProvider;

  private final Provider<AlarmManager> alarmManagerProvider;

  private final Provider<AlarmRepository> alarmRepositoryProvider;

  private final Provider<BaseSchedulerProvider> schedulerProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public AlarmDetailPresenter_Factory(
      Provider<AlarmDetailContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    assert viewProvider != null;
    this.viewProvider = viewProvider;
    assert alarmSourceProvider != null;
    this.alarmSourceProvider = alarmSourceProvider;
    assert alarmManagerProvider != null;
    this.alarmManagerProvider = alarmManagerProvider;
    assert alarmRepositoryProvider != null;
    this.alarmRepositoryProvider = alarmRepositoryProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert threadExecutorProvider != null;
    this.threadExecutorProvider = threadExecutorProvider;
    assert postExecutionThreadProvider != null;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public AlarmDetailPresenter get() {
    return new AlarmDetailPresenter(
        viewProvider.get(),
        alarmSourceProvider.get(),
        alarmManagerProvider.get(),
        alarmRepositoryProvider.get(),
        schedulerProvider.get(),
        threadExecutorProvider.get(),
        postExecutionThreadProvider.get());
  }

  public static Factory<AlarmDetailPresenter> create(
      Provider<AlarmDetailContract.View> viewProvider,
      Provider<AlarmSource> alarmSourceProvider,
      Provider<AlarmManager> alarmManagerProvider,
      Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<BaseSchedulerProvider> schedulerProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new AlarmDetailPresenter_Factory(
        viewProvider,
        alarmSourceProvider,
        alarmManagerProvider,
        alarmRepositoryProvider,
        schedulerProvider,
        threadExecutorProvider,
        postExecutionThreadProvider);
  }
}
