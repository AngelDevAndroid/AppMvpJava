package com.angandroid.appmvprxjava.di;

import android.app.Application;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.view.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {DgrModule.class})
public interface AppComponent {

    void inject(MainActivity view);

    @Component.Builder
    interface Builder {
        Builder dgrModule(DgrModule module);
        AppComponent build();
    }

    // Motor ->
    //----------------------------------------------------------------------------------------------

    // MVP ->
    /*void inject(IApiService service);*/
    // void inject(InterfaceData.IModel model);
    //void inject(InterfaceData.IPresenter presenter);
}
