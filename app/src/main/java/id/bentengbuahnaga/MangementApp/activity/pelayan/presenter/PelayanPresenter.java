package id.bentengbuahnaga.MangementApp.activity.pelayan.presenter;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.pelayan.contract.PelayanContract;
import id.bentengbuahnaga.MangementApp.activity.pelayan.model.PelayanModel;
import id.bentengbuahnaga.MangementApp.activity.pelayan.response_model.ResponseDefaultPelayan;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PelayanPresenter implements PelayanContract.Presenter {
    private static final String TAG = "PelayanPresenter";
    private PelayanContract.View v;

    public PelayanPresenter(PelayanContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initMain();
    }

    @Override
    public void daftarAntar() {
        Call<ResponseDefaultPelayan> daftarAntar = InitRetrofit.getInstance().daftarAntar();
        daftarAntar.enqueue(new Callback<ResponseDefaultPelayan>() {
            @Override
            public void onResponse(Call<ResponseDefaultPelayan> call, Response<ResponseDefaultPelayan> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ResponseDefaultPelayan res = response.body();
                    if (res.isStatus()) {
                        List<PelayanModel> item = res.getDaftarAntar();
                        v.loadDaftarAntar(item);
                        v.pesan(res.getMessage());
                    } else {
                        v.pesan(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefaultPelayan> call, Throwable t) {
                v.pesan(t.getMessage());
            }
        });
    }

    @Override
    public void updateDaftarAntar(String status, String idPesanan, String idMenu,  int position) {
        Call<ResponseDefaultPelayan> updateAntar = InitRetrofit.getInstance().updatePelayan(status, idPesanan, idMenu);
        updateAntar.enqueue(new Callback<ResponseDefaultPelayan>() {
            @Override
            public void onResponse(Call<ResponseDefaultPelayan> call, Response<ResponseDefaultPelayan> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ResponseDefaultPelayan res = response.body();
                    if (res.isStatus()) {
                        v.pesan(res.getMessage());
                        v.succesUpdate(position);
                    } else {
                        v.pesan(res.getMessage());
                        v.daftarKosong();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDefaultPelayan> call, Throwable t) {
                v.pesan(t.getMessage());
                v.daftarKosong();
            }
        });

    }

    @Override
    public void dataKosong() {
        v.daftarKosong();
    }
}
