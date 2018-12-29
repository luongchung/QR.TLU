package com.company.luongchung.adapters;


import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.company.luongchung.models.LopMonHoc;
import com.company.luongchung.models.getTTDiemDanhResult;
import com.company.luongchung.tluqr.R;

import java.util.ArrayList;


public class AdapterTTDiemDanh extends ArrayAdapter<getTTDiemDanhResult> {
    Activity context;
    int resource;
    ArrayList<getTTDiemDanhResult> objects;
    public AdapterTTDiemDanh(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<getTTDiemDanhResult> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();

        Typeface font = Typeface.createFromAsset(this.context.getAssets(),"fonts/fontmain.ttf");
        View row = layoutInflater.inflate(this.resource, null);
        getTTDiemDanhResult item=objects.get(position);
        TextView txtTenBuoi=row.findViewById(R.id.txt1TenBuoiHoc);
        CheckBox txtCheck=row.findViewById(R.id.txt1Check);
        TextView txtDiaDiem=row.findViewById(R.id.txt1DiaDiem);
        TextView txtTGDD=row.findViewById(R.id.txt1NgayHoc);
        /////
        txtTGDD.setText(item.getTgDiemDanh());
        txtTenBuoi.setText(item.getTenBuoiHoc());
        txtDiaDiem.setText("Địa điểm: "+item.getDiaDiem());
        //////
        txtTenBuoi.setTypeface(font);
        txtDiaDiem.setTypeface(font);
        txtCheck.setTypeface(font);
        txtTGDD.setTypeface(font);


        if(item.isCoMat())txtCheck.setChecked(true);
        else txtCheck.setChecked(false);




        return row;
    }
}
