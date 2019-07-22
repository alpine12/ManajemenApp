package id.bentengbuahnaga.MangementApp.activity.dapur.model;

import com.google.gson.annotations.SerializedName;

import id.bentengbuahnaga.MangementApp.activity.dapur.contract.CekBahanContract;

public class CekBahanModel implements CekBahanContract.Model {

    @SerializedName("harga")
    private String harga;

    @SerializedName("nama_bahan")
    private String namaBahan;

    @SerializedName("satuan")
    private String satuan;

    @SerializedName("qty")
    private String qty;

    @SerializedName("id_bahan")
    private String idBahan;

    @SerializedName("bagian")
    private String bagian;

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getHarga(){
        return harga;
    }

    public String getNamaBahan(){
        return namaBahan;
    }

    public String getSatuan(){
        return satuan;
    }

    public String getQty(){
        return qty;
    }

    public String getIdBahan(){
        return idBahan;
    }

    public String getBagian(){
        return bagian;
    }
}
