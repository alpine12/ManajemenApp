package id.bentengbuahnaga.MangementApp.activity.dapur.response_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.dapur.model.BerandaKokiModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.CekBahanModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.login.model.LoginModel;


public class ResponseDefaultKoki {

    @SerializedName("daftar bahan")
    private List<CekBahanModel> daftarBahan;

    @SerializedName("daftar selesai masak")
    private List<DaftarMasakModel> daftarSelesaiMasak;

    @SerializedName("daftar masak")
    private List<DaftarMasakModel> daftarMasak;

    @SerializedName("daftar pesanan")
    private List<BerandaKokiModel> daftarPesanan;

    @SerializedName("pengguna")
    private LoginModel pengguna;

    @SerializedName("token_key")
    private String tokenKey;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public String getTokenKey() {
        return tokenKey;
    }

    public List<CekBahanModel> getDaftarBahan() {
        return daftarBahan;
    }

    public List<DaftarMasakModel> getDaftarSelesaiMasak() {
        return daftarSelesaiMasak;
    }

    public List<DaftarMasakModel> getDaftarMasak() {
        return daftarMasak;
    }

    public List<BerandaKokiModel> getDaftarPesanan() {
        return daftarPesanan;
    }

    public LoginModel getPengguna() {
        return pengguna;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}