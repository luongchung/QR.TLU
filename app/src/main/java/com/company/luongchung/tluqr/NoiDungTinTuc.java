package com.company.luongchung.tluqr;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dmax.dialog.SpotsDialog;


public class NoiDungTinTuc extends AppCompatActivity {
    TextView labndtt;
    Intent intent;
    WebView webView;
    String LinkURL;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_tin_tuc);
        labndtt= findViewById(R.id.lb_noidungtintuc);
        Typeface font = Typeface.createFromAsset(this.getAssets(),"fonts/fontmain.ttf");
        labndtt.setTypeface(font);
        webView= findViewById(R.id.wv_tintuc);
        intent = getIntent();
        LinkURL = intent.getStringExtra("LinkURL");
        webView.getSettings().setJavaScriptEnabled(true);
        dialog = new SpotsDialog(NoiDungTinTuc.this,R.style.Custom);
        dialog.setCanceledOnTouchOutside(false);
        new GetHTML().execute();
    }
    class GetHTML extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            webView.loadDataWithBaseURL(null, s, "text/html", "UTF-8", null);
            dialog.dismiss();
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected String doInBackground(String... params) {
            String html="";
            try
            {
                Document doc = Jsoup.connect(LinkURL).timeout(20*1000).get();
                Elements elements = doc.select("div.primary");
                html=elements.toString();
            } catch (Exception ex){ }
            String html_xuly=xulyhtml(html);
            return "<style>img{display: inline; max-height: 270px; max-width: 100%;} iframe{display: inline;max-height: 270px; max-width: 100%;}</style>"+html_xuly;
        }
    }
    private String xulyhtml(String html) {
        return html.replaceAll("src=\"/", "src=\"http://tlu.edu.vn/");
    }
}

