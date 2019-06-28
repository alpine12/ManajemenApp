package id.bentengbuahnaga.MangementApp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
    private static String URL = "http://192.168.0.101/";
    private static String BaseUrl =URL+"simcafe/api_manajemen/";
    private static String IMG_URL = URL+"simcafe/assets/img/foto_menu/";



    private static Retrofit init(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    public static ApiInterface getInstance(){
        return init().create(ApiInterface.class);
    }

    public static String getImgUrl(){
        return IMG_URL;
    }
}
