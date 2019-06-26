package id.bentengbuahnaga.MangementApp.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.adapter.BerandaKokiAdapter;
import id.bentengbuahnaga.MangementApp.activity.contract.BerandaKokiContract;
import id.bentengbuahnaga.MangementApp.activity.model.BerandaKokiModel;
import id.bentengbuahnaga.MangementApp.activity.presenter.BerandaKokiPresenter;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class BerandaKokiActivity extends AppCompatActivity implements BerandaKokiContract.View {
    private static final String TAG = "BerandaKokiActivity";
    private Context context;
    private BerandaKokiPresenter presenter;
    private RecyclerView rvDaftarPesanan;
    private BerandaKokiAdapter adapter;
    private View notDataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_koki);

        presenter = new BerandaKokiPresenter(this);
        presenter.intimain();
    }

    @Override
    public void initView() {
        context = this;
        rvDaftarPesanan = findViewById(R.id.rv_daftarPesanan);
        notDataView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvDaftarPesanan.getParent(), false);
        adapter = new BerandaKokiAdapter();

    }

    @Override
    public void initEvent() {
        rvDaftarPesanan.setHasFixedSize(true);
        rvDaftarPesanan.setLayoutManager(new LinearLayoutManager(this));
        rvDaftarPesanan.setAdapter(adapter);
    }

    @Override
    public void loadItem(List<BerandaKokiModel> item) {
        adapter.setNewData(item);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                BerandaKokiModel item = (BerandaKokiModel) adapter.getItem(position);
                Toast.makeText(context, item.getKodeMeja(), Toast.LENGTH_SHORT).show();
                PindahActivity.PindahParam(context, DaftarMasakActivity.class, item.getIdPesanan());
            }
        });

        if (item.size()<1){
            presenter.setDataKosong();
        }
    }

    @Override
    public void tampilPesan(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dataKosong() {
        adapter.setNewData(null);
        adapter.setEmptyView(notDataView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.daftarPesanan();

    }
}
