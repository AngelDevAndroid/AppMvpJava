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

    // Square ->
    InterfaceData.IPresenter presenter;

    @Inject
    public DataInteractImpl(InterfaceData.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void mToSquare(int sNum) {
        int resultSquare = sNum * sNum;
        presenter.pShowResult(String.valueOf(resultSquare));
    }
}
