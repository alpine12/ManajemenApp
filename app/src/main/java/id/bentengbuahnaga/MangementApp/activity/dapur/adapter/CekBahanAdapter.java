package id.bentengbuahnaga.MangementApp.activity.dapur.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.CekBahanModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.presenter.CekBahanPresenter;
import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefaultKoki;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CekBahanAdapter extends BaseQuickAdapter<CekBahanModel, BaseViewHolder> {
    private CekBahanPresenter p;
    private BaseViewHolder v;
    private  EditText editText;
    private String value;


    public CekBahanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CekBahanModel item) {

        v= helper;

        helper.setText(R.id.tv_nama_bahan, item.getNamaBahan());
        helper.setText(R.id.tv_qty_lama, item.getQty() + " " + item.getSatuan());
        helper.addOnClickListener(R.id.btn_updateBahan);

    }
}
