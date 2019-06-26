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

        void loadItem(List<DaftarMasakModel> item);

        void tampilPesan(String message);


        void dataKosong();
    }

    interface Presenter {
        void intimain();

        void daftarPesanan(String idPesanan);

        void selesaiMasak(String idMenu,String idPesanan);

        void setDatakosong();
    }
}
