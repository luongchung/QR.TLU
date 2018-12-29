package com.company.luongchung.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class getTTDiemDanhResult {
    @SerializedName("CoMat")
    private boolean coMat;

    @SerializedName("GhiChu")
    private String ghiChu;

    @SerializedName("ID")
    private String id;

    @SerializedName("NgayHoc")
    private String ngayHoc;

    @SerializedName("TGDiemDanh")
    private String tgDiemDanh;

    @SerializedName("TenBuoiHoc")
    private String tenBuoiHoc;

    @SerializedName("TenDiaDiem")
    private String diaDiem;


    public getTTDiemDanhResult() {
    }

    public getTTDiemDanhResult(boolean coMat, String ghiChu, String id, String ngayHoc, String tgDiemDanh, String tenBuoiHoc, String diaDiem) {
        this.coMat = coMat;
        this.ghiChu = ghiChu;
        this.id = id;
        this.ngayHoc = ngayHoc;
        this.tgDiemDanh = tgDiemDanh;
        this.tenBuoiHoc = tenBuoiHoc;
        this.diaDiem = diaDiem;
    }

    public boolean isCoMat() {
        return coMat;
    }

    public void setCoMat(boolean coMat) {
        this.coMat = coMat;
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

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getTgDiemDanh() {
        return tgDiemDanh;
    }

    public void setTgDiemDanh(String tgDiemDanh) {
        this.tgDiemDanh = tgDiemDanh;
    }

    public String getTenBuoiHoc() {
        return tenBuoiHoc;
    }

    public void setTenBuoiHoc(String tenBuoiHoc) {
        this.tenBuoiHoc = tenBuoiHoc;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
}
