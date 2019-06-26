package id.bentengbuahnaga.MangementApp.helper;

import android.content.Context;
import android.content.Intent;

public class PindahActivity {

    public static void Pindah(Context context, Class<?> tujuan){
        Intent intent = new Intent(context, tujuan);
        context.startActivity(intent);
    }

    public static void PindahParam(Context context, Class<?> tujuan, String param){
        Intent intent = new Intent(context, tujuan);
        intent.putExtra("param", param);
        context.startActivity(intent);
    }
}
