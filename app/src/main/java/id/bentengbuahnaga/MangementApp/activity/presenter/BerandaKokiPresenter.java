package id.bentengbuahnaga.MangementApp.activity.presenter;

import android.util.Log;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.contract.BerandaKokiContract;
import id.bentengbuahnaga.MangementApp.activity.model.BerandaKokiModel;
import id.bentengbuahnaga.MangementApp.activity.response_model.ResponseDefault;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaKokiPresenter implements BerandaKokiContract.Presenter {
    private static final String TAG = "BerandaKokiPresenter";
    private BerandaKokiContract.View v;

    public BerandaKokiPresenter(BerandaKokiContract.View v) {
        this.v = v;
    }

    @Override
    public void intimain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void daftarPesanan() {
        Call<ResponseDefault> daftarPesanan = InitRetrofit.getInstance().daftarPesanan("daftar meja", "1");
        daftarPesanan.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                ResponseDefault res = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    if (res.isStatus()) {
                        List<BerandaKokiModel> item = res.getDaftarPesanan();
                        v.tampilPesan(res.getMessage());
                        v.loadItem(item);
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
    public void setDataKosong() {
        v.dataKosong();
    }
}
