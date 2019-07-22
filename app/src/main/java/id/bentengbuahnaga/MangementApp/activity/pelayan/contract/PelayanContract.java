package id.bentengbuahnaga.MangementApp.activity.pelayan.contract;

import android.widget.Adapter;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.pelayan.model.PelayanModel;

public interface PelayanContract {
    interface Model {
    }

    interface View {

        void initView();

        void initMain();

        void loadDaftarAntar(List<PelayanModel> item);

        void daftarKosong();

        void pesan(String pesan);

        void succesUpdate(int position);
    }

    interface Presenter {

        void initMain();

        void daftarAntar();

        void updateDaftarAntar(String status, String idPesanan, String idMenu, int position);

        void dataKosong();
    }
}
