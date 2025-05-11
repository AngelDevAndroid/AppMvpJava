package com.angandroid.appmvprxjava.presenter;

import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.model.DataInteractImpl;
import com.angandroid.appmvprxjava.network.IApiService;

import javax.inject.Inject;

public class DataPresenterImpl implements InterfaceData.IPresenter {

    IApiService service;

    //@Inject
    InterfaceData.IView view;
    //@Inject
    InterfaceData.IModel model;

    @Inject // <- Esto habilita la inyección de constructor
    public DataPresenterImpl(IApiService service, InterfaceData.IView view) {
        this.service = service;
        this.view = view;
        model = new DataInteractImpl(service, this);
    }

    @Override
    public void checkCredentials(String user, String password) {
        if (view != null) {
            model.checkCredentialsModel("", "");
        }
    }

    @Override
    public void msgErrorResp() {
         if (view != null) {
             view.msgErrorResp();
         }
    }

    @Override
    public void msgSuccessResp() {
        if (view != null) {
            view.msgSuccessResp();
        }
    }
}

