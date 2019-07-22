package id.bentengbuahnaga.MangementApp.activity.dapur.contract;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.dapur.model.CekBahanModel;

public interface CekBahanContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void loadBahan(List<CekBahanModel> item);

        void tampilPesan(String pesan);
    }

    interface Presenter {

        void initMain();

        void getBahan();

        void updateBahan(String idBahan, String qty);
    }
}
