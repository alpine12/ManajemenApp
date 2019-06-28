package id.bentengbuahnaga.MangementApp.activity.dapur.model;

import com.google.gson.annotations.SerializedName;

import id.bentengbuahnaga.MangementApp.activity.dapur.contract.DaftarMasakContract;

public class DaftarMasakModel implements DaftarMasakContract.Model {

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("jumlah")
    private String jumlah;

    @SerializedName("kode_meja")
    private String kodeMeja;

    @SerializedName("id_menu")
    private String idMenu;

    @SerializedName("gambar")
    private String gambar;

    public DaftarMasakModel(String namaMenu, String jumlah, String kodeMeja, String idMenu, String gambar) {
        this.namaMenu = namaMenu;
        this.jumlah = jumlah;
        this.kodeMeja = kodeMeja;
        this.idMenu = idMenu;
        this.gambar = gambar;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getKodeMeja() {
        return kodeMeja;
    }

    public String getGambar() {
        return gambar;
    }
}
