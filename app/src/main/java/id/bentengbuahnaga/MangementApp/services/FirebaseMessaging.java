package id.bentengbuahnaga.MangementApp.services;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.pelayan.PelayanActivity;
import id.bentengbuahnaga.MangementApp.app.App;

public class FirebaseMessaging extends FirebaseMessagingService {
    private static final String TAG = "FirebaseMessaging";
    private Bitmap bitmap;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            String title = remoteMessage.getData().get("title");
            String text = remoteMessage.getData().get("message");
            String gambar = remoteMessage.getData().get("gambar");
            bitmap = getBitmapfromUrl(gambar);
            int id = new Random().nextInt(1000);
//            int id = Integer.parseInt(remoteMessage.getData().get("id"));
            // refreshOnnotif();
            notifications(id, title, text, bitmap);
           

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
               // scheduleJob();
            } else {
                // Handle message within 10 seconds
                //handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(token);
    }

    private void notifications(int id, String title, String text, Bitmap gambar) {

        Notification builder = new NotificationCompat.Builder(this, App.CHANEL_ID)
                .setSmallIcon(R.mipmap.ic_icon_round)
                .setLargeIcon(gambar)
                .setContentTitle(title)
                .setContentText(text)
                .setContentInfo("info")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(id,builder);

    }

    private void refreshOnnotif(){
        Log.d(TAG, "refreshOnnotif: ");
        if (App.getInstance().getCurrentactivity() != null && App.getInstance().getCurrentactivity() instanceof
                PelayanActivity) {
                ((PelayanActivity) App.getInstance().getCurrentactivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((PelayanActivity) App.getInstance().getCurrentactivity()).onNotifRefresh();
                        Log.d(TAG, "run: runnnnnnnnnnnnnnnn");
                    }
                });
            }
    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
}
