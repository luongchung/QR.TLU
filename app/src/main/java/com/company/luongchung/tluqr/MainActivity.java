package com.company.luongchung.tluqr;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.luongchung.models.InforSinhVien;
import com.company.luongchung.retrofit.APIClient;
import com.company.luongchung.retrofit.APIInterface;
import com.company.luongchung.statics.Session;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    private String TRANG_THAI="TrangThaiLogin";
    //nut chuc năng
    private Button btn_Qr,btn_Schedule,btn_News,btn_Support;
    //nut lưu thoat trang thái
    private Button btnLuu,btnThoat;
    private EditText txtMSV;
    private TextView txtMaSV,txtTenSV;
    private LinearLayout out_Login, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_Qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Session.user!=null){
                    Intent intentQR=new Intent(MainActivity.this,ScanQR.class);
                    startActivity(intentQR);
                }else {
                    Toast.makeText(MainActivity.this, "Bạn phải đăng nhập mới sử dụng chức năng này!", Toast.LENGTH_LONG).show();
                }


            }
        });
        btn_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNews=new Intent(MainActivity.this,News.class);
                startActivity(intentNews);
            }
        });
        btn_Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiInterface = APIClient.getClient().create(APIInterface.class);
                Call<InforSinhVien> call = apiInterface.getSV(txtMSV.getText().toString().trim());
                call.enqueue(new Callback<InforSinhVien>() {
                    @Override
                    public void onResponse(Call<InforSinhVien> call, Response<InforSinhVien> response) {
                        InforSinhVien resource = response.body();
                        if(resource!=null){
                            KiemtraInforThanhCong(resource);
                        }else {
                            if(response.code()==200) Toast.makeText(MainActivity.this, "KHÔNG TÌM THẤY SINH VIÊN !", Toast.LENGTH_SHORT).show();
                            else Toast.makeText(MainActivity.this, "SERVER KHÔNG PHẢN HỒI !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<InforSinhVien> call, Throwable t) {
                        call.cancel();
                    }

                });
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xóa trạng thái

                //Ẩn hiện layout
                out_Login.setVisibility(View.INVISIBLE);
                login.setVisibility(View.VISIBLE);
                SharedPreferences sharedPreferences= getSharedPreferences(TRANG_THAI,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("login",false);
                editor.apply();
                Session.user =null;

            }
        });

    }


    private void KiemtraInforThanhCong(final InforSinhVien resource) {

        new AlertDialog.Builder(MainActivity.this).setTitle("KIỂM TRA THÔNG TIN")
                .setMessage("MSV: "+resource.getMSV()
                        +"\nHVT: "+resource.getTenSV()
                        +"\nNgày Sinh: "+resource.getNgaySinh()
                        +"\nGiới tính: "+resource.getGioiTinh()
                        +"\nKhoa: "+resource.getTenKhoa()
                        +"\nĐịa chỉ: "+resource.getDiaChi()
                )
                .setPositiveButton("Đúng là tôi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //SetTEXT
                        txtTenSV.setText("HVT: "+resource.getTenSV());
                        txtMaSV.setText("MSV: "+resource.getMSV());
                        //Chuyển layout
                        out_Login.setVisibility(View.VISIBLE);
                        login.setVisibility(View.INVISIBLE);
                        //save
                        SharedPreferences sharedPreferences= getSharedPreferences(TRANG_THAI,MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(resource);
                        editor.putString("user", json);
                        editor.putBoolean("login",true);
                        editor.apply();
                        Session.user=resource;
                    }
                }).setNegativeButton("Không phải tôi",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtMaSV.setText("");
                    }
                }
        ).show();




    }

    private void addControls() {
        btn_Qr=findViewById(R.id.btn_Qr);
        btn_Schedule=findViewById(R.id.btn_Schedule);
        btn_News=findViewById(R.id.btn_News);
        btn_Support=findViewById(R.id.btn_Support);
        out_Login=findViewById(R.id.layout_outLogin);
        login = findViewById(R.id.layout_login);
        txtMSV =findViewById(R.id.txtMSV);
        btnLuu=findViewById(R.id.btnLuuTrangThai);
        btnThoat=findViewById(R.id.btnThoatTrangThai);
        txtTenSV=findViewById(R.id.txtTenSV);
        txtMaSV=findViewById(R.id.txtMaSV);

        //Check trạng thái
        SharedPreferences sharedPreferences= getSharedPreferences(TRANG_THAI,MODE_PRIVATE);
        Boolean kt=sharedPreferences.getBoolean("login",false);
        if(kt)
        {
            out_Login.setVisibility(View.VISIBLE);
            login.setVisibility(View.INVISIBLE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("user", "");
            Session.user = gson.fromJson(json, InforSinhVien.class);
            if(Session.user!=null){
                txtMaSV.setText(Session.user.getMSV());
                txtTenSV.setText(Session.user.getTenSV());
            }
        }else {
            out_Login.setVisibility(View.INVISIBLE);
            login.setVisibility(View.VISIBLE);
        }

    }



}
