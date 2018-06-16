package com.rocklobstre.parrot.alarmreceiver;

import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.parrot.util.FragmentScoped;

import dagger.Component;

/**
 * Since AlarmDetailComponent is dependent upon the ReminderRepository, when must make
 * satisfy the dependency by supplying TaskRepositoryComponent.class.
 * Created by Ryan on 16/03/2017.
 */
@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = AlarmReceiverPresenterModule.class)
public interface AlarmReceiverComponent {

    void inject(AlarmReceiverFragment alarmReceiverFragment);
}
