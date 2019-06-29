package id.bentengbuahnaga.MangementApp.activity.login.presenter;

import com.pixplicity.easyprefs.library.Prefs;

import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefault;
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
    public void login(String user, String Pass) {
        Call<ResponseDefault> cekLogin = InitRetrofit.getInstance().ceklogin(user, Pass);
        cekLogin.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        LoginModel item = res.getPengguna();
                        v.suksesLogin(item.getBagian());
                        v.saveSharedPreff(item);
                        v.tampilPesan(res.getMessage());

                    } else {
                        v.tampilPesan(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefault> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });
    }


}