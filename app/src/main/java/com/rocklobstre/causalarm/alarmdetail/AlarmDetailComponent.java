package com.rocklobstre.causalarm.alarmdetail;

import com.rocklobstre.causalarm.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.causalarm.util.FragmentScoped;

import dagger.Component;

/**
 * Since AlarmDetailComponent is dependent upon the ReminderRepository, when must make
 * satisfy the dependency by supplying TaskRepositoryComponent.class.
 * Created by Ryan on 16/03/2017.
 */
@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = AlarmDetailPresenterModule.class)
public interface AlarmDetailComponent {

    void inject(AlarmDetailFragment alarmDetailFragment);
}

