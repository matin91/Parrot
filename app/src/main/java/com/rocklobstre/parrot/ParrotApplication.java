package com.rocklobstre.parrot;

import android.app.Application;

import com.rocklobstre.parrot.dependencyinjection.components.ApplicationComponent;
import com.rocklobstre.parrot.dependencyinjection.components.DaggerApplicationComponent;
import com.rocklobstre.parrot.dependencyinjection.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class ParrotApplication extends Application {
    private ApplicationComponent applicationComponent;
    private static ParrotApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

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
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
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

    public static synchronized ParrotApplication getInstance(){
        return instance;
    }

}
