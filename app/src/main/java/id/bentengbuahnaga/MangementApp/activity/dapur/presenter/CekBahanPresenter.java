package id.bentengbuahnaga.MangementApp.activity.dapur.presenter;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.dapur.contract.CekBahanContract;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.CekBahanModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefaultKoki;
import id.bentengbuahnaga.MangementApp.helper.SharedPreff;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CekBahanPresenter implements CekBahanContract.Presenter {
    private static final String TAG = "CekBahanPresenter";
    private CekBahanContract.View v;

    public CekBahanPresenter(CekBahanContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void getBahan() {
        String bagian = Prefs.getString(SharedPreff.getBagian(), null);
        Call<ResponseDefaultKoki> bahan = InitRetrofit.getInstance().bahan(bagian);
        bahan.enqueue(new Callback<ResponseDefaultKoki>() {
            @Override
            public void onResponse(Call<ResponseDefaultKoki> call, Response<ResponseDefaultKoki> response) {
                ResponseDefaultKoki res = response.body();
                if (response.isSuccessful() && res != null) {
                    if (res.isStatus()) {
                        List<CekBahanModel> item = res.getDaftarBahan();
                        v.loadBahan(item);
                        v.tampilPesan(res.getMessage());
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

    @Override
    public void updateBahan(String idBahan, String Qty) {
        Call<ResponseDefaultKoki> updateBahan = InitRetrofit.getInstance().update_bahan(idBahan, Qty);
        updateBahan.enqueue(new Callback<ResponseDefaultKoki>() {
            @Override
            public void onResponse(Call<ResponseDefaultKoki> call, Response<ResponseDefaultKoki> response) {
                if (response.isSuccessful()){
                    if (response.body().isStatus()){
                        v.tampilPesan(response.body().getMessage());
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
