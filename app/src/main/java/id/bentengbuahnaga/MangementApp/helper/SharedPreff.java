package id.bentengbuahnaga.MangementApp.helper;

public class SharedPreff {

    private static String id_pengguna = "id_pengguna";
    private static String username = "username";
    private static String nama_pengguna = "nama_pengguna";
    private static String bagian = "bagian";
    private static String isLogin = "isLogin";
    private static String levelLogin = "levelLogin";
    private static String tokenKey = "tokenKey";

    public static String getTokenKey() {
        return tokenKey;
    }

    public static String getLevelLogin() {
        return levelLogin;
    }

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
