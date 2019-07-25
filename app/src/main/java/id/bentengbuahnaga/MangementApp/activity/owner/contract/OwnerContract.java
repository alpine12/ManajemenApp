package id.bentengbuahnaga.MangementApp.activity.owner.contract;

import java.util.List;

import id.bentengbuahnaga.MangementApp.activity.owner.response.DataPemilikItem;

public interface OwnerContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void setData(List<DataPemilikItem> item);


    }

    interface Presenter {

        void InitMain();

        void getData();
    }
}
