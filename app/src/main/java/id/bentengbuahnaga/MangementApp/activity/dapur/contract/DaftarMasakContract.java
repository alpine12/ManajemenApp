package id.bentengbuahnaga.MangementApp.activity.dapur.contract;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.dapur.model.DaftarMasakModel;

public interface DaftarMasakContract {
    interface Model {
    }

    interface View {
        void initView();

        void initEvent();

        void loadDaftarMasak(List<DaftarMasakModel> item);

        void loadDaftarSelesaiMasak(List<DaftarMasakModel> item);

        void tampilPesan(String message);

        void showLoading();

        void hideLoading();

        void dataMasakKosong();

        void dataSelsaiKosong();

        void showRvDaftarMasak();

        void showRvDaftarSelesaiMasak();

        void hideRvDaftarMasak();

        void hideRvDaftarSelesaiMasak();
    }

    interface Presenter {
        void intimain();

        void daftarPesanan(String idPesanan);

        void daftarSelesaiMasak(String idPesanan);

        void selesaiMasak(String status,String idMenu,String idPesanan);

        void setDataDaftarkosong();

        void setDataSelesaikosong();

        void checkDataKosong(List<DaftarMasakModel> item);
    }
}
