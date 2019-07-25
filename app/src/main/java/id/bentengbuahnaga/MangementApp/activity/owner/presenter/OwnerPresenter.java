package id.bentengbuahnaga.MangementApp.activity.owner.presenter;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.owner.contract.OwnerContract;
import id.bentengbuahnaga.MangementApp.activity.owner.response.DataPemilikItem;
import id.bentengbuahnaga.MangementApp.activity.owner.response.ResponsePemilik;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerPresenter implements OwnerContract.Presenter {
    private static final String TAG = "OwnerPresenter";
    private OwnerContract.View v;

    public OwnerPresenter(OwnerContract.View v) {
        this.v = v;
    }

    @Override
    public void InitMain() {
        v.initView();
        v.initEvent();

    }

    @Override
    public void getData() {
        Call<ResponsePemilik> get = InitRetrofit.getInstance().pemilik();
        get.enqueue(new Callback<ResponsePemilik>() {
            @Override
            public void onResponse(Call<ResponsePemilik> call, Response<ResponsePemilik> response) {
                ResponsePemilik res = response.body();
                if (res.isStatus()){
                    List<DataPemilikItem> item = res.getDataPemilik();
                    v.setData(item);
                }

            }

            @Override
            public void onFailure(Call<ResponsePemilik> call, Throwable t) {

            }
        });
    }
}
