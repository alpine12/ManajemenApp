package id.bentengbuahnaga.MangementApp.activity.pelayan.model;

import com.google.gson.annotations.SerializedName;

import id.bentengbuahnaga.MangementApp.activity.pelayan.contract.PelayanContract;

public class PelayanModel implements PelayanContract.Model {

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("jumlah")
    private String jumlah;

    @SerializedName("kode_meja")
    private String kodeMeja;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("id_pesanan")
    private String idPesanan;

    @SerializedName("id_menu")
    private String idMenu;

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu(){
        return namaMenu;
    }

    public String getJumlah(){
        return jumlah;
    }

    public String getKodeMeja(){
        return kodeMeja;
    }

    public String getGambar(){
        return gambar;
    }
}
