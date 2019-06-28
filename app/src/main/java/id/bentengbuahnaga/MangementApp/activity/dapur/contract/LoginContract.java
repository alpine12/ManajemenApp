package id.bentengbuahnaga.MangementApp.activity.dapur.contract;

import id.bentengbuahnaga.MangementApp.activity.dapur.model.LoginModel;

public interface LoginContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void suksesLogin();

        void saveSharedPreff(LoginModel item);

        void tampilPesan(String message);
    }

    interface Presenter {

        void initMain();

        void cekLogin();

        void login(String user, String Pass);
    }
}
