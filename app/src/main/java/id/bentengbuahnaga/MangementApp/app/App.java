package id.bentengbuahnaga.MangementApp.app;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import com.pixplicity.easyprefs.library.Prefs;

public class App extends Application {
    public static final String CHANEL_ID = "NOTIF";
    private static App mInstance = null;
    public Context currentactivity = null;

    @Override
    public void onCreate() {
        super.onCreate();

        createSharedPreff();
        createNotificationChanel();
    }

    private void createSharedPreff(){
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    private void createNotificationChanel(){

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence nama = "Notifications";
            String deskripsi = "Layanan dapur";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel chanel = new NotificationChannel(CHANEL_ID,nama,importance);
            chanel.setDescription(deskripsi);
            chanel.enableLights(true);
            chanel.setShowBadge(true);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel);
        }
    }

    public void setCurrentactivity(Context currentactivity) {
        this.currentactivity = currentactivity;
    }

    public Context getCurrentactivity() {
        return currentactivity;
    }

    public static App getInstance() {
        if (mInstance == null) {
            mInstance = new App();
        }
        return mInstance;
    }

}
