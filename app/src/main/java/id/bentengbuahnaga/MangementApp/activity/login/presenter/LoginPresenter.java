package id.bentengbuahnaga.MangementApp.activity.login.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pixplicity.easyprefs.library.Prefs;

import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefaultKoki;
import id.bentengbuahnaga.MangementApp.activity.login.contract.LoginContract;
import id.bentengbuahnaga.MangementApp.activity.login.model.LoginModel;
import id.bentengbuahnaga.MangementApp.helper.SharedPreff;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
    private LoginContract.View v;

    public LoginPresenter(LoginContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void cekLogin() {
        if (Prefs.getBoolean(SharedPreff.getIsLogin(), false)) {
            String loginLevel = Prefs.getString(SharedPreff.getBagian(), null);
            if (loginLevel.equals("1")) {
                v.suksesLogin(loginLevel);
            } else if (loginLevel.equals("4")) {
                v.suksesLogin(loginLevel);
            } else if (loginLevel.equals("5")) {
                v.suksesLogin(loginLevel);
            } else if (loginLevel.equals("6")) {
                v.suksesLogin(loginLevel);
            } else {
                v.tampilPesan("Hak akses tidak dimiliki");
            }
        }
    }

    @Override
    public void login(String user, String Pass, String Token) {
        Call<ResponseDefaultKoki> cekLogin = InitRetrofit.getInstance().ceklogin(user, Pass, Token);
        cekLogin.enqueue(new Callback<ResponseDefaultKoki>() {
            @Override
            public void onResponse(Call<ResponseDefaultKoki> call, Response<ResponseDefaultKoki> response) {
                ResponseDefaultKoki res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        LoginModel item = res.getPengguna();
                        v.suksesLogin(item.getBagian());
                        v.saveSharedPreff(item);
                        v.tampilPesan(res.getMessage());
                        Prefs.putString(SharedPreff.getTokenKey(), res.getTokenKey());

                    } else {
                        v.tampilPesan(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefaultKoki> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });
    }



}
