package com.company.luongchung.models;

import com.google.gson.annotations.SerializedName;

public class Thongbao {
    @SerializedName("ketqua")
    public boolean ketqua;
    @SerializedName("text")
    public String text;

    public Thongbao(boolean ketqua, String text) {
        this.ketqua = ketqua;
        this.text = text;
    }

    public Thongbao() {
    }

    public boolean isKetqua() {
        return ketqua;
    }

    public void setKetqua(boolean ketqua) {
        this.ketqua = ketqua;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
