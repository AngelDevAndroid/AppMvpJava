package com.angandroid.appmvprxjava.presenter;

import android.annotation.SuppressLint;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.model.DataInteractImpl;
import com.angandroid.appmvprxjava.network.DataRepository;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.view.MainActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataPresenterImpl implements InterfaceData.IPresenter {

    InterfaceData.IView view;
    IApiService repository;

    public DataPresenterImpl(IApiService repository) {
        this.repository = repository;
    }

    @Override
    public void attachView(InterfaceData.IView view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadMessage() {

        if (view != null) {
            repository.getPokemonList() .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(users -> {
                        view.onUsersReceived(users);
                    }, throwable -> {
                        view.onError(throwable.getMessage());
                    });
            //view.showMessage(msg);
        }
    }

    @Override
    public void pShowResult(String result) {
        if (view != null) {
            view.vShowResult(result);
        }
    }

    @Override
    public void pToSquare(int sNum) {
        if (view != null) {
            //model.mToSquare(sNum);
        }
    }
}

