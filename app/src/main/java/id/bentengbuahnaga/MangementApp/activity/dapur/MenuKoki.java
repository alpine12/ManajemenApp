package id.bentengbuahnaga.MangementApp.activity.dapur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.zip.Inflater;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.SplashScreen;
import id.bentengbuahnaga.MangementApp.activity.login.LoginActivity;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class MenuKoki extends AppCompatActivity {
    private static final String TAG = "MenuKoki";
    private Context mContext;
    private CardView berandaKoki;
    private CardView cekBahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_koki);

        mContext = this;
        berandaKoki = findViewById(R.id.beranda_koki);
        cekBahan = findViewById(R.id.cek_bahan);

        berandaKoki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                berandaKoki();
            }
        });

        cekBahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekBahan();
            }
        });
    }

    public void berandaKoki() {
        PindahActivity.Pindah(mContext, BerandaKokiActivity.class);
    }

    public void cekBahan() {
        PindahActivity.Pindah(mContext, CekBahanActivity.class);
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
