package id.bentengbuahnaga.MangementApp.activity.login;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.dapur.BerandaKokiActivity;
import id.bentengbuahnaga.MangementApp.activity.dapur.MenuKoki;
import id.bentengbuahnaga.MangementApp.activity.login.contract.LoginContract;
import id.bentengbuahnaga.MangementApp.activity.login.model.LoginModel;
import id.bentengbuahnaga.MangementApp.activity.login.presenter.LoginPresenter;
import id.bentengbuahnaga.MangementApp.activity.owner.OwnerActivity;
import id.bentengbuahnaga.MangementApp.activity.pelayan.PelayanActivity;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;
import id.bentengbuahnaga.MangementApp.helper.SharedPreff;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    private Context context;
    private LoginPresenter presenter;
    private EditText user;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);

        presenter.initMain();
    }

    @Override
    public void initView() {
        context = this;
        user = findViewById(R.id.et_username);
        pass = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);
    }

    @Override
    public void initEvent() {
        presenter.cekLogin();
    }

    @Override
    public void suksesLogin(String level) {
        if (level.equals("1")) {
            PindahActivity.Pindah(context, OwnerActivity.class);
        } else if (level.equals("4")) {
            PindahActivity.Pindah(context, PelayanActivity.class);
        } else if (level.equals("5")) {
            PindahActivity.Pindah(context, BerandaKokiActivity.class);
        }else if (level.equals("6")) {
            PindahActivity.Pindah(context, MenuKoki.class);
        }
    }

    @Override
    public void saveSharedPreff(LoginModel item) {
        Prefs.putString(SharedPreff.getId_pengguna(), item.getIdPengguna());
        Prefs.putString(SharedPreff.getBagian(), item.getBagian());
        Prefs.putString(SharedPreff.getNama_pengguna(), item.getNamaPengguna());
        Prefs.putString(SharedPreff.getUsername(), item.getUsername());
        Prefs.putBoolean(SharedPreff.getIsLogin(), true);
    }

    @Override
    public void tampilPesan(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "tampilPesan: " + message);
    }

    public void login(View view) {

        presenter.login(user.getText().toString(), pass.getText().toString());
    }
}