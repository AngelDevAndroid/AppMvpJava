package com.angandroid.appmvprxjava.di;

import android.app.Application;
import android.content.Context;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.view.MainActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PokeApplication extends Application {

    static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .dgrModule(new DgrModule()).build();

        Realm.init(this);
        confRealm();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    // Realm
    public void confRealm() {
        RealmConfiguration rc = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(rc);
    }
}
