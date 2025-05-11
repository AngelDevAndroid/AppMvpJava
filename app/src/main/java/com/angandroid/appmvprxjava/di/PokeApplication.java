package com.angandroid.appmvprxjava.di;

import android.app.Application;
import android.content.Context;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;

public class PokeApplication extends Application {

    static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().dgrModule(new DgrModule()).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
