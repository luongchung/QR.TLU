package com.company.luongchung.tluqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_Qr,btn_Schedule,btn_News,btn_Support;
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
                Intent intentQR=new Intent(MainActivity.this,ScanQR.class);
                startActivity(intentQR);
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

    }

    private void addControls() {
        btn_Qr=findViewById(R.id.btn_Qr);
        btn_Schedule=findViewById(R.id.btn_Schedule);
        btn_News=findViewById(R.id.btn_News);
        btn_Support=findViewById(R.id.btn_Support);
    }
}
