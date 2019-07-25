package id.bentengbuahnaga.MangementApp.activity.owner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.SplashScreen;
import id.bentengbuahnaga.MangementApp.activity.owner.contract.OwnerContract;
import id.bentengbuahnaga.MangementApp.activity.owner.presenter.OwnerPresenter;
import id.bentengbuahnaga.MangementApp.activity.owner.response.DataPemilikItem;
import id.bentengbuahnaga.MangementApp.helper.FormatRp;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class OwnerActivity extends AppCompatActivity implements OwnerContract.View {
    private static final String TAG = "OwnerActivity";
    private Context mContext;
    private OwnerPresenter presenter;
    private TextView pendapatan;
    private TextView transaksi;
    private TextView meja;
    private TextView diskon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        mContext = this;
        presenter = new OwnerPresenter(this);
        presenter.InitMain();
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

    @Override
    public void initView() {
        pendapatan = findViewById(R.id.tv_pendapatanHarian);
        transaksi = findViewById(R.id.tv_transaksiHariIni);
        meja = findViewById(R.id.tv_mejaTerpakai);
        diskon = findViewById(R.id.tv_diskon);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void setData(List<DataPemilikItem> item) {
        for (int i =0; i<item.size(); i++){

            pendapatan.setText(FormatRp.FormatRp(item.get(0).getSetoran()));
            transaksi.setText(item.get(1).getPesanan()+" Transaksi");
            meja.setText(item.get(2).getMeja()+" Meja");
            diskon.setText(item.get(3).getPromo()+ " promo");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getData();
    }
}
