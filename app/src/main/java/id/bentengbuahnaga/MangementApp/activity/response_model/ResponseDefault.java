package id.bentengbuahnaga.MangementApp.activity.response_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.model.BerandaKokiModel;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;
import id.bentengbuahnaga.MangementApp.activity.model.LoginModel;


public class ResponseDefault {

    @SerializedName("daftar selesai masak")
    private List<DaftarMasakModel> daftarSelesaiMasak;

    @SerializedName("daftar masak")
    private List<DaftarMasakModel> daftarMasak;

    @SerializedName("daftar pesanan")
    private List<BerandaKokiModel> daftarPesanan;

    @SerializedName("pengguna")
    private LoginModel pengguna;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

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