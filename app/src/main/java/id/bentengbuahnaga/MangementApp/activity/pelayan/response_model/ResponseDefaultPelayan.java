package id.bentengbuahnaga.MangementApp.activity.pelayan.response_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.pelayan.model.PelayanModel;

public class ResponseDefaultPelayan {

    @SerializedName("daftar antar")
    private List<PelayanModel> daftarAntar;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public List<PelayanModel> getDaftarAntar() {
        return daftarAntar;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}