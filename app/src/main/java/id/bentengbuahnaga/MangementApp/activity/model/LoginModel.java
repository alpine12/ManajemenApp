package id.bentengbuahnaga.MangementApp.activity.model;

import com.google.gson.annotations.SerializedName;

import id.bentengbuahnaga.MangementApp.activity.contract.LoginContract;

public class LoginModel implements LoginContract.Model {

    @SerializedName("password")
    private String password;

    @SerializedName("date_created")
    private String dateCreated;

    @SerializedName("nama_pengguna")
    private String namaPengguna;

    @SerializedName("bagian")
    private String bagian;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("email")
    private String email;

    @SerializedName("aktif")
    private String aktif;

    @SerializedName("id_pengguna")
    private String idPengguna;

    @SerializedName("username")
    private String username;

    public String getPassword() {
        return password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getBagian() {
        return bagian;
    }

    public String getGambar() {
        return gambar;
    }

    public String getEmail() {
        return email;
    }

    public String getAktif() {
        return aktif;
    }

    public String getIdPengguna() {
        return idPengguna;
    }

    public String getUsername() {
        return username;
    }
}
