package id.bentengbuahnaga.MangementApp.activity.owner.response;

import com.google.gson.annotations.SerializedName;

public class DataPemilikItem {

    @SerializedName("promo")
    private String promo;

    @SerializedName("meja")
    private String meja;

    @SerializedName("pesanan")
    private String pesanan;

    @SerializedName("setoran")
    private String setoran;

    public String getPromo() {
        return promo;
    }

    public String getMeja() {
        return meja;
    }

    public String getPesanan() {
        return pesanan;
    }

    public String getSetoran() {
        return setoran;
    }
}