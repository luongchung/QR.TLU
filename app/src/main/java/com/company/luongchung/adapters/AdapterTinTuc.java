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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.company.luongchung.models.TinTuc_m;
import com.company.luongchung.tluqr.NoiDungTinTuc;
import com.company.luongchung.tluqr.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterTinTuc extends ArrayAdapter<TinTuc_m> {
    Activity context;
    int resource;
    ArrayList<TinTuc_m> objects;
    public AdapterTinTuc(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<TinTuc_m> objects) {
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

        try {
        TextView id_TieuDe= row.findViewById(R.id.id_Tieu_De);
        TextView id_TomTat= row.findViewById(R.id.id_Tom_Tat);
        ImageView id_Anh= row.findViewById(R.id.id_Anh);
        final TinTuc_m tinTucM =objects.get(position);
        id_TieuDe.setText(tinTucM.getTieuDe());
        id_TomTat.setText(tinTucM.getTomTat());
        id_TieuDe.setTypeface(font);

        String urlAnh= tinTucM.getUrlHinh();

      //  Picasso.with(context).load(urlAnh).into(id_Anh);

        Glide.with(context)
                .load(urlAnh)
                .apply(new RequestOptions().override(100, 100))
                .into(id_Anh);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuly_click_TinTuc(tinTucM);
            }
        });



        }catch (Exception ex){

        }
        return row;
    }

    private void xuly_click_TinTuc(TinTuc_m tinTucM) {
        Intent intent=new Intent(context,NoiDungTinTuc.class);
        intent.putExtra("LinkURL", tinTucM.getUrlLink());
        context.startActivityForResult(intent,13);
    }
}
