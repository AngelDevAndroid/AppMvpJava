package com.angandroid.appmvprxjava.di;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.interfaces.InterfaceDataRealm;
import com.angandroid.appmvprxjava.network.DataRepository;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.network.RealmRepository;
import com.angandroid.appmvprxjava.pract_dagger.Car;
import com.angandroid.appmvprxjava.pract_dagger.Motor;
import com.angandroid.appmvprxjava.presenter.DataPresenterImpl;
import com.angandroid.appmvprxjava.presenter.RealmPresenterImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RealmModule {

    //----------------------------------------------------------------------------------------------

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }


    @Provides
    RealmRepository provideRealmRepo(Realm realm) {
        return new RealmRepository(realm);
    }

    @Provides
    InterfaceDataRealm.IRmPresenter providePresenter(RealmRepository repository) {
        return new RealmPresenterImpl(repository);
    }
}
