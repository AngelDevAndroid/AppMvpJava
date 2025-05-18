package com.angandroid.appmvprxjava.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.angandroid.appmvprxjava.R;
import com.angandroid.appmvprxjava.databinding.ActivityMainBinding;
import com.angandroid.appmvprxjava.di.DaggerAppComponent;
import com.angandroid.appmvprxjava.di.DgrModule;
import com.angandroid.appmvprxjava.di.PokeApplication;
import com.angandroid.appmvprxjava.interfaces.InterfaceData;
import com.angandroid.appmvprxjava.interfaces.InterfaceDataRealm;
import com.angandroid.appmvprxjava.model.DataInteractImpl;
import com.angandroid.appmvprxjava.network.IApiService;
import com.angandroid.appmvprxjava.network.Post;
import com.angandroid.appmvprxjava.pract_dagger.Car;
import com.angandroid.appmvprxjava.pract_dagger.Motor;
import com.angandroid.appmvprxjava.presenter.DataPresenterImpl;
import com.angandroid.appmvprxjava.realm.DevelopersModel;
import com.angandroid.appmvprxjava.utils_reuse.UtilsCode;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements InterfaceData.IView, InterfaceDataRealm.IRmView  {

    // Views
    ActivityMainBinding bindMain;

    @Named("Gasolina")
    @Inject
    Motor motor;

    @Inject
    Car car;

    @Inject
    InterfaceData.IPresenter iPresenter;
    @Inject
    InterfaceDataRealm.IRmPresenter iRmPresenter;

    @Inject
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        bindMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindMain.getRoot());

        PokeApplication.getAppComponent().inject(this);

        iPresenter.attachView(this);
        iRmPresenter.attachView(this);

        DevelopersModel devs = new DevelopersModel();

        devs.setId(iRmPresenter.setIdRm());
        devs.setName("Juan Pérez");
        devs.setCodeProg("Kotlin");

        iPresenter.loadMessage();
        iRmPresenter.vSaveDev(devs);
        //delDevByIdX(7);
        iRmPresenter.pReadDataDev();

        loadDataPoke();
        getDataMotor();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getDataMotor() {
        iPresenter.loadMessage();
        Log.d("DGR_TST", motor.getTypeMotor() + " - " + car.getMotor());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUsersReceived(List<Post> users) {
        Log.d("DGR_TST", users.get(0).getTitle());
    }

    @Override
    public void onError(String message) {
        Log.d("DGR_TST", message);
    }

    public void loadDataPoke() {
        //iPresenter.checkCredentials("", "");
    }

    // Square ->
    @Override
    public void vShowResult(String result) {
        Log.d("DGR_TST", result);
    }

    @Override
    public void getListDevs(List<DevelopersModel> lstDevs) {
        for (int i = 0; i < lstDevs.size(); i++) {
            Log.d("DGR_RM->", "" + lstDevs.get(i).getCodeProg());
        }
    }

    @Override
    public void setMsgSuccess(String msgSuccess) {
        new UtilsCode().setMsgToast(msgSuccess, this);
    }

    @Override
    public void setMsgError(String error) {
       new UtilsCode().setMsgToast("Error:" + error, this);
    }

    @Override
    public void delDevById(String idDev) {
       // iRmPresenter.delDevById("3");
    }

    public void delDevByIdX(int idDev) {
        iRmPresenter.delDevById(idDev);
    }
}