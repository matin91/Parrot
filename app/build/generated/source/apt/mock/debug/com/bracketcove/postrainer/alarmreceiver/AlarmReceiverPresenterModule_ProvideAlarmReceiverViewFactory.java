package com.rocklobstre.parrot.alarmreceiver;

import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverContract;
import com.rocklobstre.parrot.alarmreceiver.AlarmReceiverPresenterModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AlarmReceiverPresenterModule_ProvideAlarmReceiverViewFactory
    implements Factory<AlarmReceiverContract.View> {
  private final AlarmReceiverPresenterModule module;

  public AlarmReceiverPresenterModule_ProvideAlarmReceiverViewFactory(
      AlarmReceiverPresenterModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AlarmReceiverContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAlarmReceiverView(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AlarmReceiverContract.View> create(AlarmReceiverPresenterModule module) {
    return new AlarmReceiverPresenterModule_ProvideAlarmReceiverViewFactory(module);
  }

  /** Proxies {@link AlarmReceiverPresenterModule#provideAlarmReceiverView()}. */
  public static AlarmReceiverContract.View proxyProvideAlarmReceiverView(
      AlarmReceiverPresenterModule instance) {
    return instance.provideAlarmReceiverView();
  }
}
