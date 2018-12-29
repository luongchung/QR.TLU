package com.company.luongchung.models;

import com.google.gson.annotations.SerializedName;

public class LopMonHoc {
    @SerializedName("GhiChu")
    private String ghiChu;

    @SerializedName("ID")
    private String id;

    @SerializedName("IDGiangVien")
    private String idGiangVien;

    @SerializedName("IsKT")
    private String isKT;

    @SerializedName("MaLopMonHoc")
    private String maLopMonHoc;

    @SerializedName("SoTinChi")
    private String soTinChi;

    @SerializedName("TenLopMonHoc")
    private String tenLopMonHoc;

    @SerializedName("TongSoTiet")
    private String tongSoTiet;

    public LopMonHoc() {
    }

    public LopMonHoc(String ghiChu, String id, String idGiangVien, String isKT, String maLopMonHoc, String soTinChi, String tenLopMonHoc, String tongSoTiet) {
        this.ghiChu = ghiChu;
        this.id = id;
        this.idGiangVien = idGiangVien;
        this.isKT = isKT;
        this.maLopMonHoc = maLopMonHoc;
        this.soTinChi = soTinChi;
        this.tenLopMonHoc = tenLopMonHoc;
        this.tongSoTiet = tongSoTiet;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdGiangVien() {
        return idGiangVien;
    }

    public void setIdGiangVien(String idGiangVien) {
        this.idGiangVien = idGiangVien;
    }

    public String getIsKT() {
        return isKT;
    }

    public void setIsKT(String isKT) {
        this.isKT = isKT;
    }

    public String getMaLopMonHoc() {
        return maLopMonHoc;
    }

    public void setMaLopMonHoc(String maLopMonHoc) {
        this.maLopMonHoc = maLopMonHoc;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTenLopMonHoc() {
        return tenLopMonHoc;
    }

    public void setTenLopMonHoc(String tenLopMonHoc) {
        this.tenLopMonHoc = tenLopMonHoc;
    }

    public String getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(String tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }
}
