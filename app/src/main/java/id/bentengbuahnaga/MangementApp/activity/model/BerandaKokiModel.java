package id.bentengbuahnaga.MangementApp.activity.model;

import com.google.gson.annotations.SerializedName;

import id.bentengbuahnaga.MangementApp.activity.contract.BerandaKokiContract;

public class BerandaKokiModel implements BerandaKokiContract.Model {

    @SerializedName("catatan")
    private String catatan;

    @SerializedName("kode_meja")
    private String kodeMeja;

    @SerializedName("id_pesanan")
    private String idPesanan;

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getCatatan() {
        return catatan;
    }

    public String getKodeMeja() {
        return kodeMeja;
    }
}
