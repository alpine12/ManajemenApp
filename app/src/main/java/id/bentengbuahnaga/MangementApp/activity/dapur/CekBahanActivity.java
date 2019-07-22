package id.bentengbuahnaga.MangementApp.activity.dapur;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import id.bentengbuahnaga.MangementApp.R;
import id.bentengbuahnaga.MangementApp.activity.dapur.adapter.CekBahanAdapter;
import id.bentengbuahnaga.MangementApp.activity.dapur.contract.CekBahanContract;
import id.bentengbuahnaga.MangementApp.activity.dapur.model.CekBahanModel;
import id.bentengbuahnaga.MangementApp.activity.dapur.presenter.CekBahanPresenter;

public class CekBahanActivity extends AppCompatActivity implements CekBahanContract.View {
    private static final String TAG = "CekBahanActivity";
    private CekBahanPresenter p;
    private RecyclerView rvBahan;
    private View emeptyView;
    private CekBahanAdapter adapter;
    private ImageButton back;
    private TextView title;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_bahan);
        p = new CekBahanPresenter(this);
        p.initMain();
    }

    @Override
    public void initView() {
        back = findViewById(R.id.backArrow);
        title = findViewById(R.id.title_toolbar);
        mContext = this;
        rvBahan = findViewById(R.id.rv_bahan);
        emeptyView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvBahan.getParent(), false);
        adapter = new CekBahanAdapter(R.layout.list_item_layout_cek_bahan);
    }

    @Override
    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title.setText("Cek Stok Bahan");
        rvBahan.setHasFixedSize(true);
        rvBahan.setLayoutManager(new LinearLayoutManager(this));
        p.getBahan();

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CekBahanModel model = (CekBahanModel) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.btn_updateBahan:

                        final EditText editText = new EditText(mContext);
                        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        editText.setSingleLine();
                        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});

                        new SweetAlertDialog(mContext, SweetAlertDialog.NORMAL_TYPE)
                                .setTitleText("Data Baru")
                                .setConfirmText("Ok")
                                .setCustomView(editText)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        p.updateBahan(model.getIdBahan(), editText.getText().toString());
                                        model.setQty(editText.getText().toString());
                                        sweetAlertDialog.dismissWithAnimation();
                                        adapter.notifyItemChanged(position);
                                    }
                                })
                                .show();
                        break;
                }
            }
        });


    }

    @Override
    public void loadBahan(List<CekBahanModel> item) {
        adapter.setNewData(item);
        rvBahan.setAdapter(adapter);
    }

    @Override
    public void tampilPesan(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }
}
