package id.bentengbuahnaga.MangementApp.activity.dapur.presenter;

import android.util.Log;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.dapur.contract.DaftarMasakContract;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefault;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarMasakPresenter implements DaftarMasakContract.Presenter {
    private static final String TAG = "DaftarMasakPresenter";
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
        Call<ResponseDefault> daftarPesanan = InitRetrofit.getInstance().daftarMasak("daftar masak", idPesanan, "1");
        daftarPesanan.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    if (res.isStatus()) {
                        List<DaftarMasakModel> item = res.getDaftarMasak();
                        v.loadDaftarMasak(item);
                        v.tampilPesan(res.getMessage());
                    } else {
                        v.tampilPesan(res.getMessage());
                        v.dataMasakKosong();
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
    public void daftarSelesaiMasak(String idPesanan) {
        Call<ResponseDefault> daftarPesanan = InitRetrofit.getInstance().daftarMasak("daftar selesai", idPesanan, "1");
        daftarPesanan.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    if (res.isStatus()) {
                        List<DaftarMasakModel> item = res.getDaftarSelesaiMasak();
                        Log.d(TAG, "onResponse: " + item.size());
                        v.loadDaftarSelesaiMasak(item);
                        v.tampilPesan(res.getMessage());
                    } else {
                        v.tampilPesan(res.getMessage());
                        v.dataSelsaiKosong();
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
    public void selesaiMasak(String status, String idMenu, String idPesanan) {
        v.showLoading();
        Call<ResponseDefault> selesaiMasak = InitRetrofit.getInstance().selesaiMasak(status, idMenu, idPesanan);
        selesaiMasak.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && res != null) {
                    if (res.isStatus()) {
                        v.tampilPesan(res.getMessage());
                        v.hideLoading();
                    } else {
                        v.tampilPesan(res.getMessage());
                       // v.dataMasakKosong();
                        v.hideLoading();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefault> call, Throwable t) {
                v.tampilPesan(t.getMessage());
                v.hideLoading();
            }
        });
    }

    @Override
    public void setDataDaftarkosong() {
        v.dataMasakKosong();
    }

    @Override
    public void setDataSelesaikosong() {
        v.dataSelsaiKosong();
    }


    @Override
    public void checkDataKosong(List<DaftarMasakModel> item) {
        if (item.size() < 1) {
            v.hideRvDaftarMasak();
        } else {
            v.showRvDaftarMasak();
        }
    }
}
