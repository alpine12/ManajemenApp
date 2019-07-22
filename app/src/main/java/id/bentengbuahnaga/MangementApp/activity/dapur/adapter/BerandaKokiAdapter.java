package id.bentengbuahnaga.MangementApp.activity.dapur.adapter;

import android.util.Log;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.BerandaKokiModel;

public class BerandaKokiAdapter extends BaseQuickAdapter<BerandaKokiModel, BaseViewHolder> {


    public BerandaKokiAdapter() {
        super(R.layout.list_item_layout_daftarpesanan);
    }

    @Override
    protected void convert(BaseViewHolder helper, BerandaKokiModel item) {
        ((TextView) helper.getView(R.id.tv_kodeMeja)).setText(item.getKodeMeja());
        ((TextView) helper.getView(R.id.tv_catatan)).setText(item.getCatatan());
        helper.setText(R.id.tv_jumlahPesan, item.getJumlah()+" Pesanan");
        Log.d(TAG, "convert: "+item.getKodeMeja());
        helper.addOnClickListener(R.id.linearLayout);
    }
}
