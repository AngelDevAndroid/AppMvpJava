package com.angandroid.appmvprxjava.model;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.network.Pokemon;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataInteractImpl implements InterfaceData.IModel {

    //@Inject
    IApiService apiService;

    //@Inject
    InterfaceData.IPresenter presenter;

    @Inject
    public DataInteractImpl(IApiService apiService, InterfaceData.IPresenter presenter) {
        this.apiService = apiService;
        this.presenter = presenter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void checkCredentialsModel(String user, String password) {
         if (user.isEmpty() || password.isEmpty()) {
              presenter.msgErrorResp();
         }else {
               presenter.checkCredentials(user, password);
         }

         apiService.getPokemonList()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(
                         usuarios -> {
                             // Manejar la lista de usuarios
                             Log.d("RESP_API ->", usuarios.toString());
                         },
                         throwable -> {
                             Log.d("RESP_API ->", throwable.toString());
                             // Manejar el error
                         }
                 );
    }
}
