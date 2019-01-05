package com.company.luongchung.tluqr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.company.luongchung.models.Thongbao;
import com.company.luongchung.statics.Session;
import com.company.luongchung.models.getLopMonHocTheoDiaDiemResult;
import com.company.luongchung.qrcode.ZXingScannerView;
import com.company.luongchung.retrofit.APIClient;
import com.company.luongchung.retrofit.APIInterface;
import com.company.luongchung.statics.Session;
import com.google.gson.Gson;
import com.google.zxing.Result;
import android.Manifest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScanQR extends Activity implements ZXingScannerView.ResultHandler  {
    private static String iDDiaDiem;
    private static String toKen;

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mScannerView;
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
        int apiVersion = android.os.Build.VERSION.SDK_INT;
        if (apiVersion >= Build.VERSION_CODES.LOLLIPOP) {
            if (!checkPermission()) {
                requestPermission();
            }
        }
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //set time scan
        mScannerView.setAspectTolerance(0.1f);
    }
    private boolean checkPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted){
                        Toast.makeText(getApplicationContext(), "Được cập quyền, Bạn có thể truy xuất camera !", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Không được cập quyền, Bạn không thê truy xuất Camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                                showMessage("Bạn cần cho phép truy cập Camera",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void showMessage(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ScanQR.this)
                .setMessage(message)
                .setPositiveButton("Đóng", okListener)
                .create()
                .show();
    }
    @Override
    public void handleResult(Result result) {
        String trave=result.getText().trim();
        String[] data = trave.split(",", 2);
        iDDiaDiem=data[0];
        toKen=data[1];
        Call<List<getLopMonHocTheoDiaDiemResult>> call = apiInterface.GetLopMonHocTheoDiaDiem(data[0]);
        call.enqueue(new Callback<List<getLopMonHocTheoDiaDiemResult>>() {
            @Override
            public void onResponse(Call<List<getLopMonHocTheoDiaDiemResult>> call, Response<List<getLopMonHocTheoDiaDiemResult>> response) {
                List<getLopMonHocTheoDiaDiemResult> resource = response.body();
                if(resource!=null){
                    thanhCong(resource);
                }else {
                    if(response.code()==200) Toast.makeText(ScanQR.this, "KHÔNG TÌM THẤY SINH VIÊN !", Toast.LENGTH_SHORT).show();
                    else if(response.code()==400)Toast.makeText(ScanQR.this, "SERVER KHÔNG PHẢN HỒI !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<getLopMonHocTheoDiaDiemResult>> call, Throwable t) {

            }
        });





    }

    private void thanhCong(final List<getLopMonHocTheoDiaDiemResult> resource) {
        if (resource.size()==0){
            new android.support.v7.app.AlertDialog.Builder(ScanQR.this).setTitle("Thông báo")
                    .setMessage("KHÔNG TÌM THẤY LỚP NÀO !"
                    ).setNegativeButton("Quét lại",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mScannerView.resumeCameraPreview(ScanQR.this);
                        }
                    }
            ).show();
        }else
        new android.support.v7.app.AlertDialog.Builder(ScanQR.this).setTitle("XÁC NHẬN ĐIỂM DANH")
                .setMessage("Mã môn: "+resource.get(0).getMaLopMonHoc()+"\n"
                            +"Tên lớp học: "+resource.get(0).getTenLopMonHoc()+"\n"
                            +"Buổi học: "+resource.get(0).getTenBuoiHoc()+"\n"
                            +"Giảng viên: "+resource.get(0).getTenNV()
                )
                .setPositiveButton("Điểm danh", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       diemdanhSV(resource.get(0).getID(),Session.user.getID(),toKen);


                    }
                }).setNegativeButton("Quét lại",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      mScannerView.resumeCameraPreview(ScanQR.this);
                    }
                }
        ).show();
    }

    private void diemdanhSV(String idBuoiHoc,String idSinhVien,String toKen ) {
        Call<Thongbao> call = apiInterface.diemdanhsv(idSinhVien,idBuoiHoc,toKen);
        call.enqueue(new Callback<Thongbao>() {
            @Override
            public void onResponse(Call<Thongbao> call, Response<Thongbao> response) {
                if(response.body()!=null){
                    new android.support.v7.app.AlertDialog.Builder(ScanQR.this).setTitle("Thông báo")
                            .setMessage(response.body().getText()
                            ).setNegativeButton("Đóng",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }
                    ).show();
                }
                else {
                   if(response.code()==400)Toast.makeText(ScanQR.this, "SERVER KHÔNG PHẢN HỒI !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Thongbao> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }



}
