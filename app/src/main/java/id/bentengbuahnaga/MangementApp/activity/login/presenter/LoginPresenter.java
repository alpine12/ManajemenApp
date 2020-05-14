package id.bentengbuahnaga.MangementApp.activity.login.presenter;

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
            switch (loginLevel) {
                case "1":
                    v.suksesLogin(loginLevel);
                    break;
                case "4":
                    v.suksesLogin(loginLevel);
                    break;
                case "5":
                    v.suksesLogin(loginLevel);
                    break;
                case "6":
                    v.suksesLogin(loginLevel);
                    break;
                default:
                    v.tampilPesan("Hak akses tidak dimiliki");
                    break;
            }
        }
    }

    @Override
    public void login(String user, String Pass, String Token) {
        Call<ResponseDefaultKoki> cekLogin = InitRetrofit.getInstance().ceklogin(user, Pass, Token);
        cekLogin.enqueue(new Callback<ResponseDefaultKoki>() {
            @Override
            public void onResponse(Call<ResponseDefaultKoki> call, Response<ResponseDefaultKoki> response) {

                if (response.isSuccessful()) {
                    ResponseDefaultKoki res = response.body();
                    if (res.isStatus()) {
                        LoginModel item = res.getPengguna();
                        v.suksesLogin(item.getBagian());
                        v.saveSharedPreff(item);
                        v.tampilPesan(res.getMessage());
                        Prefs.putString(SharedPreff.getTokenKey(), res.getTokenKey());//
                    } else {
                        v.tampilPesan(res.getMessage());
                    }

                } else {
                    v.tampilPesan("error");
                }
            }

            @Override
            public void onFailure(Call<ResponseDefaultKoki> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });
    }



}
