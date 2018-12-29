package com.company.luongchung.tluqr;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.company.luongchung.adapters.AdapterSpiner;
import com.company.luongchung.adapters.AdapterTTDiemDanh;
import com.company.luongchung.models.LopMonHoc;
import com.company.luongchung.models.getTTDiemDanhResult;
import com.company.luongchung.retrofit.APIClient;
import com.company.luongchung.retrofit.APIInterface;
import com.company.luongchung.statics.Session;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraCuuDiemDanh extends AppCompatActivity {
    private Spinner spinner;
    private TextView lable;
    private int index=-1;
    ListView lvMain;
    AdapterTTDiemDanh adapterTTDiemDanh;
    ArrayList<getTTDiemDanhResult> arrGetTTDiemDanhResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_diem_danh);
        arrGetTTDiemDanhResult =new ArrayList<>();
        adControll();
    }

    private void adControll() {
        lable =findViewById(R.id.txtLable);
        lvMain=findViewById(R.id.lvDiemDanh);
        Typeface font = Typeface.createFromAsset(this.getAssets(),"fonts/fontmain.ttf");
        lable.setTypeface(font);
        spinner=findViewById(R.id.spiner);
        ArrayList<LopMonHoc> list =new ArrayList<>();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<LopMonHoc>> call = apiInterface.getLopMonHoc(Session.user.getID());;
        call.enqueue(new Callback<ArrayList<LopMonHoc>>() {
            @Override
            public void onResponse(Call<ArrayList<LopMonHoc>> call, Response<ArrayList<LopMonHoc>> response) {
                ArrayList<LopMonHoc> resource = response.body();
                if(resource!=null){
                    LoadDSLopMonHoc(resource);
                }else {
                   if(response.code()==400)Toast.makeText(TraCuuDiemDanh.this, "SERVER KHÔNG PHẢN HỒI !", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<LopMonHoc>> call, Throwable t) {
                call.cancel();
            }

        });


    }

    private void LoadDSLopMonHoc(final ArrayList<LopMonHoc> resource) {
        AdapterSpiner adapter = new AdapterSpiner(TraCuuDiemDanh.this,R.layout.item_spiner,resource);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index=i;
                if(index==-1)return;
                loadListTTDiemDanh(resource.get(index).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadListTTDiemDanh(String idLMH) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<getTTDiemDanhResult>> call1 = apiInterface.getTTLopMonHoc(Session.user.getID(),idLMH);;
        call1.enqueue(new Callback<ArrayList<getTTDiemDanhResult>>() {
            @Override
            public void onResponse(Call<ArrayList<getTTDiemDanhResult>> call, Response<ArrayList<getTTDiemDanhResult>> response) {
                ArrayList<getTTDiemDanhResult> resource = response.body();
                if(resource!=null){
                    //arrGetTTDiemDanhResult =resource;
                    showListTTDiemDanh(resource);
                }else {
                    if(response.code()==400)Toast.makeText(TraCuuDiemDanh.this, "SERVER KHÔNG PHẢN HỒI !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<getTTDiemDanhResult>> call, Throwable t) {

            }
        });
    }

    private void showListTTDiemDanh(  ArrayList<getTTDiemDanhResult> arr) {
        adapterTTDiemDanh=new AdapterTTDiemDanh(TraCuuDiemDanh.this,R.layout.item_diemdanh, arr);
        lvMain.setAdapter(adapterTTDiemDanh);

    }
}
