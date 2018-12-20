package com.company.luongchung.models;

import com.google.gson.annotations.SerializedName;

public class getLopMonHocTheoDiaDiemResult {
    @SerializedName("ID")
    private String ID;
    @SerializedName("IDLopMonHoc")
    private String IDLopMonHoc;
    @SerializedName("MaLopMonHoc")
    private String MaLopMonHoc;
    @SerializedName("TenBuoiHoc")
    private String TenBuoiHoc;
    @SerializedName("TenLopMonHoc")
    private String TenLopMonHoc;
    @SerializedName("TenNV")
    private String TenNV;

    public getLopMonHocTheoDiaDiemResult() {
    }

    public getLopMonHocTheoDiaDiemResult(String ID, String IDLopMonHoc, String maLopMonHoc, String tenBuoiHoc, String tenLopMonHoc, String tenNV) {
        this.ID = ID;
        this.IDLopMonHoc = IDLopMonHoc;
        MaLopMonHoc = maLopMonHoc;
        TenBuoiHoc = tenBuoiHoc;
        TenLopMonHoc = tenLopMonHoc;
        TenNV = tenNV;
    }

    @Override
    public String toString() {
        return "getLopMonHocTheoDiaDiemResult{" +
                "ID='" + ID + '\'' +
                ", IDLopMonHoc='" + IDLopMonHoc + '\'' +
                ", MaLopMonHoc='" + MaLopMonHoc + '\'' +
                ", TenBuoiHoc='" + TenBuoiHoc + '\'' +
                ", TenLopMonHoc='" + TenLopMonHoc + '\'' +
                ", TenNV='" + TenNV + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDLopMonHoc() {
        return IDLopMonHoc;
    }

    public void setIDLopMonHoc(String IDLopMonHoc) {
        this.IDLopMonHoc = IDLopMonHoc;
    }

    public String getMaLopMonHoc() {
        return MaLopMonHoc;
    }

    public void setMaLopMonHoc(String maLopMonHoc) {
        MaLopMonHoc = maLopMonHoc;
    }

    public String getTenBuoiHoc() {
        return TenBuoiHoc;
    }

    public void setTenBuoiHoc(String tenBuoiHoc) {
        TenBuoiHoc = tenBuoiHoc;
    }

    public String getTenLopMonHoc() {
        return TenLopMonHoc;
    }

    public void setTenLopMonHoc(String tenLopMonHoc) {
        TenLopMonHoc = tenLopMonHoc;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }
}
