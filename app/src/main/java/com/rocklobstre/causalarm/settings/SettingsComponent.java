package com.rocklobstre.causalarm.settings;

import com.rocklobstre.causalarm.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.causalarm.util.FragmentScoped;

import dagger.Component;

/**
 * Created by Ryan on 16/03/2017.
 */

@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = SettingsPresenterModule.class)
public interface SettingsComponent {

    void inject(SettingsFragment settingsFragment);

}
