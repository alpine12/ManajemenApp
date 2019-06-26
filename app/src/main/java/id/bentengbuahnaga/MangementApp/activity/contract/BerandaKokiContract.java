package id.bentengbuahnaga.MangementApp.activity.contract;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.model.BerandaKokiModel;

public interface BerandaKokiContract {
    interface Model {
    }

    interface View {
        void initView();

        void initEvent();

        void loadItem(List<BerandaKokiModel> item);

        void tampilPesan(String message);

        void dataKosong();
    }

    interface Presenter {

        void intimain();

        void daftarPesanan();

        void setDataKosong();
    }
}
