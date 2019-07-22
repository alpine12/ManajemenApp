package id.bentengbuahnaga.MangementApp.activity.login.contract;

import id.bentengbuahnaga.MangementApp.activity.login.model.LoginModel;

public interface LoginContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void suksesLogin(String level);

        void saveSharedPreff(LoginModel item);

        void tampilPesan(String message);
    }

    interface Presenter {

        void initMain();

        void cekLogin();

        void login(String user, String Pass,  String Token);
    }
}
