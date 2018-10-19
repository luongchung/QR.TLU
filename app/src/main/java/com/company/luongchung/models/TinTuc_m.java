package com.company.luongchung.models;

/**
 * Created by LUONG CHUNG on 7/4/2017.
 */

public class TinTuc_m {
    private String tieuDe;
    private String tomTat;
    private String urlHinh;
    private String urlLink;

    public TinTuc_m(String tieuDe, String tomTat, String urlHinh, String urlLink) {
        this.tieuDe = tieuDe;
        this.tomTat = tomTat;
        this.urlHinh = urlHinh;
        this.urlLink = urlLink;
    }

    public TinTuc_m() {
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getUrlHinh() {
        return urlHinh;
    }

    public void setUrlHinh(String urlHinh) {
        this.urlHinh = urlHinh;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
}
