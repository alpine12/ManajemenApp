package id.bentengbuahnaga.MangementApp.activity.pelayan.adapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.pelayan.model.PelayanModel;
import id.bentengbuahnaga.MangementApp.network.InitRetrofit;

public class PelayanAdapter extends BaseQuickAdapter<PelayanModel, BaseViewHolder> {
    public PelayanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PelayanModel item) {
        Picasso.get().load(InitRetrofit.getImgUrl()+item.getGambar()).fit()
                .into(((ImageView) helper.getView(R.id.iconMenu)));
        ((TextView) helper.getView(R.id.tv_namaMakanan)).setText(item.getNamaMenu());
        ((TextView) helper.getView(R.id.tv_kodeMeja)).setText(item.getKodeMeja());
        ((TextView) helper.getView(R.id.tv_jumlahPesan)).setText("Jumlah Pesanan : "+item.getJumlah());
        helper.addOnClickListener(R.id.btn_selesai);

    }
}
