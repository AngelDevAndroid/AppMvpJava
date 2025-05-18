package com.angandroid.appmvprxjava.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.angandroid.appmvprxjava.interfaces.InterfaceDataRealm;
import com.angandroid.appmvprxjava.network.RealmRepository;
import com.angandroid.appmvprxjava.realm.DevelopersModel;

import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class RealmPresenterImpl implements InterfaceDataRealm.IRmPresenter {

    InterfaceDataRealm.IRmView view;
    RealmRepository repository;

    private CompositeDisposable cd = new CompositeDisposable();

    @Inject
    public RealmPresenterImpl(RealmRepository repository) {
        this.repository = repository;
    }

    @Override
    public void attachView(InterfaceDataRealm.IRmView view) {
        this.view = view;
    }

    @Override
    public int setIdRm() {
        return repository.setIdRealm();
    }

    @SuppressLint("CheckResult")
    @Override
    public void vSaveDev(DevelopersModel obDevs) {
        if (view != null) {
            cd.add(
            repository
                    .rSaveDevel(obDevs)
                            .subscribeOn(AndroidSchedulers.mainThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(() ->
                                view.setMsgSuccess("Guardado"),
                       throwable ->
                                Log.d("DGR_RM", "" + throwable.getMessage())
                            )
            );
        }
    }

    @SuppressLint("CheckResult")
    @Override
    public void pReadDataDev() {

        if (view != null) {
            cd.add(
              repository
                      .getDevelopers()
                      .subscribeOn(AndroidSchedulers.mainThread())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(devs ->
                                 view.getListDevs(devs),
                         throwable ->
                                 view.setMsgError(throwable.getMessage())
                      )
            );
        }
    }


    @Override
    public void delDevById(int idDev) {
        if (view != null) {
            cd.add(
              repository
                      .deleteDeveloper(idDev)
                      .subscribeOn(AndroidSchedulers.mainThread())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(
                              () -> view.setMsgSuccess("Usuario eliminado"),
                              throwable ->
                                      //Log.d("DGR_RM", "" + throwable.getMessage())
                                    view.setMsgError(throwable.getMessage())
                      )
            );
        }
    }

    // ADD IN VIEW IMPLEMENT --->
    public void onDestroy() {
        cd.clear();
    }
}

