package id.bentengbuahnaga.MangementApp.activity.presenter;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.contract.DaftarMasakContract;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.response_model.ResponseDefault;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarMasakPresenter implements DaftarMasakContract.Presenter {
    DaftarMasakContract.View v;

    public DaftarMasakPresenter(DaftarMasakContract.View v) {
        this.v = v;
    }

    @Override
    public void intimain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void daftarPesanan(String idPesanan) {
        Call<ResponseDefault> daftarPesanan = InitRetrofit.getInstance().daftarMasak(idPesanan, "1");
        daftarPesanan.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    if (res.isStatus()) {
                        List<DaftarMasakModel> item = res.getDaftarMasak();
                        v.loadItem(item);
                        v.tampilPesan(res.getMessage());
                    } else {
                        v.tampilPesan(res.getMessage());
                        v.dataKosong();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefault> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });

    }

    @Override
    public void selesaiMasak(String idMenu, String idPesanan) {
        Call<ResponseDefault> selesaiMasak = InitRetrofit.getInstance().selesaiMasak(idMenu, idPesanan);
        selesaiMasak.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && res != null) {
                    if (res.isStatus()) {
                        v.tampilPesan(res.getMessage());
                    } else {
                        v.tampilPesan(res.getMessage());
                        v.dataKosong();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefault> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });
    }

    @Override
    public void setDatakosong() {
        v.dataKosong();
    }
}
