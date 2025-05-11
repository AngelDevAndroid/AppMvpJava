package com.angandroid.appmvprxjava.di;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.network.IApiService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DgrModule.class})
public interface AppComponent {

    void inject(IApiService service);
    void inject(InterfaceData.IModel model);
    void inject(InterfaceData.IPresenter presenter);
    void inject(InterfaceData.IView view);
}
