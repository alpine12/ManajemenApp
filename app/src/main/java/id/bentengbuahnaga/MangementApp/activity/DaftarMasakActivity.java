package id.bentengbuahnaga.MangementApp.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.adapter.DaftarMasakAdapter;
import id.bentengbuahnaga.MangementApp.activity.contract.DaftarMasakContract;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.presenter.DaftarMasakPresenter;

public class DaftarMasakActivity extends AppCompatActivity implements DaftarMasakContract.View {
    private static final String TAG = "DaftarMasakActivity";
    private DaftarMasakPresenter presenter;
    private Context mContext;
    private RecyclerView rvDaftarMasak;
    private DaftarMasakAdapter adapter;
    private View notDataView;
    private TextView tvSelesaiMasak;
    private RecyclerView rvSelesaiMasak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daftar_masak);
        presenter = new DaftarMasakPresenter(this);
        presenter.intimain();

    }

    @Override
    public void initView() {
        mContext = this;
        rvDaftarMasak = findViewById(R.id.rv_daftarMasak);
        notDataView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvDaftarMasak.getParent(), false);
        tvSelesaiMasak = findViewById(R.id.tv_selesaiMasak);
        rvSelesaiMasak = findViewById(R.id.rv_selesaiMasak);
    }

    @Override
    public void initEvent() {
        rvDaftarMasak.setHasFixedSize(true);
        rvDaftarMasak.setLayoutManager(new LinearLayoutManager(this));

      //  List<DaftarMasakModel> item = new ArrayList<>();
        adapter = new DaftarMasakAdapter();
        rvDaftarMasak.setAdapter(adapter);

        tvSelesaiMasak.setVisibility(View.GONE);
        rvSelesaiMasak.setVisibility(View.GONE);

    }

    @Override
    public void loadItem(List<DaftarMasakModel> item) {
        adapter.setNewData(item);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                DaftarMasakModel masak = (DaftarMasakModel) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.btn_selesai:
                        String idPesanan = getIntent().getStringExtra("param");
                        presenter.selesaiMasak(masak.getIdMenu(), idPesanan);
                        adapter.remove(position);
                        adapter.notifyItemChanged(position);
                        if (item.size()<1){
                            presenter.setDatakosong();
                        }
                        break;
                }
            }
        });
    }

    @Override
    public void tampilPesan(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dataKosong() {
       // adapter.setNewData(null);
        adapter.setEmptyView(notDataView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String idPesanan = getIntent().getStringExtra("param");
       presenter.daftarPesanan(idPesanan);

    }
}
