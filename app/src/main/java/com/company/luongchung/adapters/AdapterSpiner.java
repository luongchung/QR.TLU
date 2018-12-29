package com.company.luongchung.adapters;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.luongchung.models.LopMonHoc;
import com.company.luongchung.models.TinTuc_m;
import com.company.luongchung.tluqr.NoiDungTinTuc;
import com.company.luongchung.tluqr.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterSpiner extends BaseAdapter {
    Activity context;
    int resource;
    ArrayList<LopMonHoc> objects;

    public AdapterSpiner(Activity context, int resource, ArrayList<LopMonHoc> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public LopMonHoc getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        Typeface font = Typeface.createFromAsset(this.context.getAssets(),"fonts/fontmain.ttf");
        View row = layoutInflater.inflate(this.resource, null);
        LopMonHoc item= objects.get(position);
        TextView txtTenLopMonHoc=row.findViewById(R.id.idTenLop);
        txtTenLopMonHoc.setText(item.getTenLopMonHoc());
        txtTenLopMonHoc.setTypeface(font);
        return row;
    }


}
