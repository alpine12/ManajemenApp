package id.bentengbuahnaga.MangementApp.activity.pelayan;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.SplashScreen;
import id.bentengbuahnaga.MangementApp.activity.pelayan.adapter.PelayanAdapter;
import id.bentengbuahnaga.MangementApp.activity.pelayan.contract.PelayanContract;
import id.bentengbuahnaga.MangementApp.activity.pelayan.model.PelayanModel;
import id.bentengbuahnaga.MangementApp.activity.pelayan.presenter.PelayanPresenter;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class PelayanActivity extends AppCompatActivity implements PelayanContract.View {
    private static final String TAG = "PelayanActivity";
    private PelayanPresenter presenter;
    private RecyclerView rvDaftarAntar;
    private PelayanAdapter adapter;
    private View empetyView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelayan);

        presenter = new PelayanPresenter(this);
        presenter.initMain();
    }

    @Override
    public void initView() {
        mContext = this;
        rvDaftarAntar = findViewById(R.id.rv_daftarAntar);
        adapter = new PelayanAdapter(R.layout.list_item_layout_daftarantar);
        empetyView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvDaftarAntar.getParent(), false);
        adapter.setEmptyView(empetyView);
    }

    @Override
    public void initMain() {
        rvDaftarAntar.setLayoutManager(new LinearLayoutManager(this));
        rvDaftarAntar.setHasFixedSize(true);
        rvDaftarAntar.setAdapter(adapter);
    }

    @Override
    public void loadDaftarAntar(List<PelayanModel> item) {
        if (item.size() == 0) {
            presenter.dataKosong();
        } else {
            adapter.setNewData(item);
            rvDaftarAntar.setAdapter(adapter);
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    PelayanModel model = (PelayanModel) adapter.getItem(position);
                    switch (view.getId()) {
                        case R.id.btn_selesai:
                            Log.d(TAG, "onItemChildClick: click");
                            presenter.updateDaftarAntar("1", model.getIdPesanan(), model.getIdMenu(), position);                           
                            if (item.size() < 1) {
                                presenter.dataKosong();
                            }
                            break;
                    }
                }
            });
        }

    }

    @Override
    public void daftarKosong() {
        adapter.setNewData(null);
        adapter.setEmptyView(empetyView);
    }

    @Override
    public void pesan(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void succesUpdate(int position) {
        adapter.remove(position);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.daftarAntar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_keluar:
                PindahActivity.Pindah(mContext, SplashScreen.class);
                finish();
                Prefs.clear();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
