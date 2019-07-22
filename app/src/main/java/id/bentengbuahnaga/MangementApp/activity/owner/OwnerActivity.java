package id.bentengbuahnaga.MangementApp.activity.owner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pixplicity.easyprefs.library.Prefs;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.SplashScreen;
import id.bentengbuahnaga.MangementApp.helper.PindahActivity;

public class OwnerActivity extends AppCompatActivity {
    private static final String TAG = "OwnerActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        mContext = this;
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
