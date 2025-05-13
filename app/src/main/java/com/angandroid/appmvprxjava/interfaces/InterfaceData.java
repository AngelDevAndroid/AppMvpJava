package com.angandroid.appmvprxjava.interfaces;

import com.angandroid.appmvprxjava.network.Post;
import com.angandroid.appmvprxjava.view.MainActivity;

import java.util.List;

public interface InterfaceData {

    interface IView {

        void vShowResult(String result);
        void showMessage(String message);

        void onUsersReceived(List<Post> users);
        void onError(String message);

         /*void showProgress();
         void hideProgress();

         void msgErrorResp();
         void msgSuccessResp();*/

    }

    interface IPresenter {

        void attachView(InterfaceData.IView view);
        void loadMessage();

        // Square ->
        void pShowResult(String result);
        void pToSquare(int sNum);

         /*void checkCredentials(String user, String password);

        void msgErrorResp();
        void msgSuccessResp();*/
    }

    // Interactor ----------------------------------------------------------------------------------
    interface IModel {
        //void checkCredentialsModel(String user, String password);

        // Square ->
        void mToSquare(int sNum);

    }
}
