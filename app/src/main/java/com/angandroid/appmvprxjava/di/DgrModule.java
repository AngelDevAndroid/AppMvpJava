package com.angandroid.appmvprxjava.di;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.model.DataInteractImpl;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.presenter.DataPresenterImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DgrModule {

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    IApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(IApiService.class);
    }

    @Provides
    InterfaceData.IModel provideModel(IApiService service, InterfaceData.IPresenter presenter) {
        return new DataInteractImpl(service, presenter);
    }

    @Provides
    InterfaceData.IView provideView(InterfaceData.IView view) {
        return view;
    }

    @Provides
    InterfaceData.IPresenter providePresenter(IApiService service, InterfaceData.IView view) {
        return new DataPresenterImpl(service, view);
    }
}
