package id.bentengbuahnaga.MangementApp.network;

import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefault;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {

    /*
     * Auth
     */
    @FormUrlEncoded
    @POST("auth")
    Call<ResponseDefault> ceklogin(@Field("user") String user,
                                   @Field("pass") String pass);

    /*
     * daftar pesanan
     */
    @GET("bagian_koki")
    Call<ResponseDefault> daftarPesanan(@Query("param") String param,
                                        @Query("kategori") String kategori);

    /*
     * daftar masak
     */
    @GET("bagian_koki")
    Call<ResponseDefault> daftarMasak(@Query("param") String daftarMasak,
                                      @Query("idPesanan") String idPesanan,
                                      @Query("kategori") String kategori);

    /*
     *selesai masak / batal masak
     */
    @FormUrlEncoded
    @PUT("bagian_koki")
    Call<ResponseDefault> selesaiMasak(@Field("status") String Status,
                                       @Field("idMenu") String idMenu,
                                       @Field("idPesanan") String idPesanan);
}
