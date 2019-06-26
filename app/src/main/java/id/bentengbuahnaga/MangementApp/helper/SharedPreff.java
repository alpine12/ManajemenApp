package id.bentengbuahnaga.MangementApp.helper;

public class SharedPreff {

    private static String id_pengguna = "id_pengguna";
    private static String username = "username";
    private static String nama_pengguna = "nama_pengguna";
    private static String bagian = "bagian";
    private static String isLogin = "isLogin";

    public static String getIsLogin() {
        return isLogin;
    }

    public static String getId_pengguna() {
        return id_pengguna;
    }

    public static String getUsername() {
        return username;
    }

    public static String getNama_pengguna() {
        return nama_pengguna;
    }

    public static String getBagian() {
        return bagian;
    }
}
