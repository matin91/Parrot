package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.parrot.util.FragmentScoped;

import dagger.Component;

/**
 * Created by Matin on 16/03/2017.
 */

@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = SettingsPresenterModule.class)
public interface SettingsComponent {

    void inject(SettingsFragment settingsFragment);

}
