package com.rocklobstre.causalarm;

import android.app.Application;

import com.rocklobstre.causalarm.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.causalarm.dependencyinjection.components.DaggerApplicationComponent;
import com.rocklobstre.causalarm.dependencyinjection.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class PostrainerApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeRealm();
        initializeLeakCanary();

        ApplicationModule applicationModule = new ApplicationModule(
                getApplicationContext()
        );

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(applicationModule)
                .build();

    }

    private void initializeRealm(){
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initializeLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
