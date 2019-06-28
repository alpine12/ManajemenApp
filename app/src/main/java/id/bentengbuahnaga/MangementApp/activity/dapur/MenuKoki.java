package id.bentengbuahnaga.MangementApp.activity.dapur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class MenuKoki extends AppCompatActivity {
    private static final String TAG = "MenuKoki";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_koki);

        mContext = this;
    }

    public void berandaKoki(View view) {
        PindahActivity.Pindah(mContext, BerandaKokiActivity.class);
    }

    public void cekBahan(View view) {
        PindahActivity.Pindah(mContext, CekBahanActivity.class);
    }
}
