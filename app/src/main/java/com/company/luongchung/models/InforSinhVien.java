package com.company.luongchung.models;

import com.google.gson.annotations.SerializedName;

public class InforSinhVien {
    @SerializedName("MSV")
    private String MSV;
    @SerializedName("TenSV")
    private String TenSV;
    @SerializedName("NgaySinh")
    private String NgaySinh;
    @SerializedName("ID")
    private String ID;
    @SerializedName("GioiTinh")
    private String GioiTinh;
    @SerializedName("DiaChi")
    private String DiaChi;
    @SerializedName("TenKhoa")
    private String TenKhoa;

    public InforSinhVien(String MSV, String tenSV, String ngaySinh, String ID, String gioiTinh, String diaChi, String tenKhoa) {
        this.MSV = MSV;
        TenSV = tenSV;
        NgaySinh = ngaySinh;
        this.ID = ID;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
        TenKhoa = tenKhoa;
    }

    public InforSinhVien() {
    }
    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }

    @Override
    public String toString() {
        return "InforSinhVien{" +
                "MSV='" + MSV + '\'' +
                ", TenSV='" + TenSV + '\'' +
                ", NgaySinh='" + NgaySinh + '\'' +
                ", ID='" + ID + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", TenKhoa='" + TenKhoa + '\'' +
                '}';
    }
}
