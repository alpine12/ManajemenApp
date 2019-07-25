package id.bentengbuahnaga.MangementApp.network;

import id.bentengbuahnaga.MangementApp.activity.dapur.response_model.ResponseDefaultKoki;
import id.bentengbuahnaga.MangementApp.activity.owner.response.ResponsePemilik;
import id.bentengbuahnaga.MangementApp.activity.pelayan.response_model.ResponseDefaultPelayan;
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
    Call<ResponseDefaultKoki> ceklogin(@Field("user") String user,
                                       @Field("pass") String pass,
                                       @Field("token") String token);

    /*
     * daftar pesanan
     */
    @GET("bagian_koki")
    Call<ResponseDefaultKoki> daftarPesanan(@Query("param") String param,
                                            @Query("bagian") String bagian,
                                            @Query("kategori") String kategori);

    /*
     * daftar masak
     */
    @GET("bagian_koki")
    Call<ResponseDefaultKoki> daftarMasak(@Query("param") String daftarMasak,
                                          @Query("idPesanan") String idPesanan,
                                          @Query("kategori") String kategori);

    /*
     *selesai masak / batal masak
     */
    @FormUrlEncoded
    @PUT("bagian_koki")
    Call<ResponseDefaultKoki> selesaiMasak(@Field("status") String Status,
                                           @Field("idMenu") String idMenu,
                                           @Field("idPesanan") String idPesanan);

    /*
     * Daftar Antar Pelayan
     */
    @GET("pelayan")
    Call<ResponseDefaultPelayan> daftarAntar();

    /*
     * Update Daftar Antar Pelayan
     */
    @FormUrlEncoded
    @PUT("pelayan")
    Call<ResponseDefaultPelayan> updatePelayan(@Field("status_antar") String status,
                                               @Field("id_pesanan") String idPesanan,
                                               @Field("id_menu") String idMenu);

    /*
     * Cek Bahan
     */
    @GET("cek_bahan")
    Call<ResponseDefaultKoki> bahan(@Query("bagian") String Bagian);

    /*
     * Update Bahan
     */
    @FormUrlEncoded
    @PUT("cek_bahan")
    Call<ResponseDefaultKoki> update_bahan(@Field("id_bahan") String idBahan,
                                           @Field("qty") String Qty);

    /*
    * Owner
     */
    @GET("owner")
    Call<ResponsePemilik> pemilik();

}
