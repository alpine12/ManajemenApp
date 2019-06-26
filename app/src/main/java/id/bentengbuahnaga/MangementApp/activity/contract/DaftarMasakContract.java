package id.bentengbuahnaga.MangementApp.activity.contract;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.model.BerandaKokiModel;
import id.bentengbuahnaga.MangementApp.activity.model.DaftarMasakModel;

public interface DaftarMasakContract {
    interface Model {
    }

    interface View {
        void initView();

        void initEvent();

        void loadItem(List<DaftarMasakModel> item, List<DaftarMasakModel> item2);

        void tampilPesan(String message);

        void showLoading();

        void hideLoading();

        void dataKosong();

        void showRvDaftarMasak();

        void showRvDaftarSelesaiMasak();

        void hideRvDaftarMasak();

        void hideRvDaftarSelesaiMasak();
    }

    interface Presenter {
        void intimain();

        void daftarPesanan(String idPesanan);

        void selesaiMasak(String status,String idMenu,String idPesanan);

        void setDatakosong();

        void checkDataKosong(List<DaftarMasakModel> item, List<DaftarMasakModel> item2);
    }
}
