package com.angandroid.appmvprxjava.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.angandroid.appmvprxjava.R;
import com.angandroid.appmvprxjava.databinding.ActivityMainBinding;
import com.angandroid.appmvprxjava.di.PokeApplication;
import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.model.DataInteractImpl;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.presenter.DataPresenterImpl;
import com.angandroid.appmvprxjava.utils_reuse.UtilsCode;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements InterfaceData.IView {

    // View
    ActivityMainBinding bindMain;

    //@Inject
    //IApiService service;
    @Inject
    InterfaceData.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        bindMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindMain.getRoot());

        iPresenter = new DataPresenterImpl(service, this);
        PokeApplication.getAppComponent().inject(this);
        loadDataPoke();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void msgErrorResp() {
        new UtilsCode().setMsgToast("Error", this);
    }

    @Override
    public void msgSuccessResp() {
        new UtilsCode().setMsgToast("Success", this);
    }

    public void loadDataPoke() {
        iPresenter.checkCredentials("", "");
    }
}