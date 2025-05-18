package com.angandroid.appmvprxjava.interfaces;

import com.angandroid.appmvprxjava.realm.DevelopersModel;

import java.util.List;

public interface InterfaceDataRealm {

    interface IRmView {
        void getListDevs(List<DevelopersModel> lstDevs);
        void setMsgSuccess(String msgSuccess);
        void setMsgError(String error);
        void delDevById(String idDev);
    }

    interface IRmPresenter {
        void attachView(InterfaceDataRealm.IRmView view);
        void vSaveDev(DevelopersModel obDevs);
        void pReadDataDev();
        int setIdRm();
        void delDevById(int idDev);

    }
}
