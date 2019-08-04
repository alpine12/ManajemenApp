package id.bentengbuahnaga.MangementApp.activity.owner.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponsePemilik {

    @SerializedName("message")
    private String message;

    @SerializedName("data_pemilik")
    private List<DataPemilikItem> dataPemilik;

    @SerializedName("status")
    private boolean status;

    public String getMessage() {
        return message;
    }

    public List<DataPemilikItem> getDataPemilik() {
        return dataPemilik;
    }

    public boolean isStatus() {
        return status;
    }
}