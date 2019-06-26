package id.bentengbuahnaga.MangementApp.activity.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;

public class DaftarMasakAdapter extends BaseQuickAdapter<DaftarMasakModel, BaseViewHolder> {


    public DaftarMasakAdapter() {
        super(R.layout.list_item_layout_daftarmasak);
    }


    @Override
    protected void convert(BaseViewHolder helper, DaftarMasakModel item) {
        Picasso.get().load(InitRetrofit.getImgUrl() + item.getGambar()).fit()
                .into((ImageView) helper.getView(R.id.imgIconMenu));
        ((TextView) helper.getView(R.id.tv_namaMenu)).setText(item.getNamaMenu());
        ((TextView) helper.getView(R.id.tv_totalMenu)).setText("Jumlah Pesanan : " + item.getJumlah());
        helper.addOnClickListener(R.id.btn_selesai);

    }
}
