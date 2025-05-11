package com.angandroid.appmvprxjava.interfaces;

public interface InterfaceData {
    interface IModel {
        void checkCredentialsModel(String user, String password);
    }

    interface IView {
         void showProgress();
         void hideProgress();

         void msgErrorResp();
         void msgSuccessResp();

    }

    interface IPresenter {
        void checkCredentials(String user, String password);

        void msgErrorResp();
        void msgSuccessResp();
    }
}
