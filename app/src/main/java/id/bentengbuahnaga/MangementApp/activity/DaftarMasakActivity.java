package id.bentengbuahnaga.MangementApp.activity;

import android.app.ProgressDialog;
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

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.adapter.DaftarMasakAdapter;
import id.bentengbuahnaga.MangementApp.activity.adapter.DaftarSelesaiMasakAdapter;
import id.bentengbuahnaga.MangementApp.activity.contract.DaftarMasakContract;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.presenter.DaftarMasakPresenter;

public class DaftarMasakActivity extends AppCompatActivity implements DaftarMasakContract.View {
    private static final String TAG = "DaftarMasakActivity";
    private DaftarMasakPresenter presenter;
    private Context mContext;
    private RecyclerView rvDaftarMasak;
    private DaftarMasakAdapter adapter;
    private DaftarSelesaiMasakAdapter adapterSelesai;
    private View notDataView;
    private TextView tvSelesaiMasak;
    private TextView tvDaftarMasak;
    private RecyclerView rvSelesaiMasak;
    private ProgressDialog dialog;

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
        tvDaftarMasak = findViewById(R.id.tvDaftarMasak);
        rvDaftarMasak = findViewById(R.id.rv_daftarMasak);
        notDataView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvDaftarMasak.getParent(), false);
        tvSelesaiMasak = findViewById(R.id.tv_selesaiMasak);
        rvSelesaiMasak = findViewById(R.id.rv_selesaiMasak);
        dialog = new ProgressDialog(this);
    }

    @Override
    public void initEvent() {
        dialog.setCancelable(false);
        dialog.setMessage("Mohon Tunggu ... ");

        rvDaftarMasak.setHasFixedSize(true);
        rvDaftarMasak.setLayoutManager(new LinearLayoutManager(this));
        rvDaftarMasak.setNestedScrollingEnabled(false);
        rvSelesaiMasak.setHasFixedSize(true);
        rvSelesaiMasak.setLayoutManager(new LinearLayoutManager(this));
        rvSelesaiMasak.setNestedScrollingEnabled(false);

        adapter = new DaftarMasakAdapter();
        adapterSelesai = new DaftarSelesaiMasakAdapter();
        rvDaftarMasak.setAdapter(adapter);
        rvSelesaiMasak.setAdapter(adapterSelesai);

    }

    @Override
    public void loadItem(List<DaftarMasakModel> item, List<DaftarMasakModel> item2) {
        presenter.checkDataKosong(item, item2);
        adapter.setNewData(item);
        adapterSelesai.setNewData(item2);
        adapter.notifyDataSetChanged();
        adapterSelesai.notifyDataSetChanged();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                DaftarMasakModel masak = (DaftarMasakModel) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.btn_selesai:
                        String idPesanan = getIntent().getStringExtra("param");
                        presenter.selesaiMasak("1", masak.getIdMenu(), idPesanan);
                        adapter.remove(position);
                        presenter.daftarPesanan(idPesanan);
                        //  presenter.checkDataKosong(item, item2);
                        if (item.size() < 1) {
                            presenter.setDatakosong();
                        }
                        break;
                }
            }
        });
        adapterSelesai.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                DaftarMasakModel masak = (DaftarMasakModel) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.btn_selesai:
                        String idPesanan = getIntent().getStringExtra("param");
                        presenter.selesaiMasak("0", masak.getIdMenu(), idPesanan);
                        adapterSelesai.remove(position);
                        presenter.daftarPesanan(idPesanan);
                        //  presenter.checkDataKosong(item, item2);
                        if (item2.size() < 1) {
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
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void dataKosong() {
        // adapter.setNewData(null);
        adapter.setEmptyView(notDataView);
    }

    @Override
    public void showRvDaftarMasak() {
        tvDaftarMasak.setVisibility(View.VISIBLE);
        rvDaftarMasak.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRvDaftarSelesaiMasak() {
        tvSelesaiMasak.setVisibility(View.VISIBLE);
        rvSelesaiMasak.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRvDaftarMasak() {
        tvDaftarMasak.setVisibility(View.GONE);
        rvDaftarMasak.setVisibility(View.GONE);
    }

    @Override
    public void hideRvDaftarSelesaiMasak() {
        tvSelesaiMasak.setVisibility(View.GONE);
        rvSelesaiMasak.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String idPesanan = getIntent().getStringExtra("param");
        presenter.daftarPesanan(idPesanan);

    }
}
