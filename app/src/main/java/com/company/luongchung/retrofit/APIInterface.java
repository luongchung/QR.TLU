package com.company.luongchung.retrofit;
import com.company.luongchung.models.LopMonHoc;
import com.company.luongchung.models.getTTDiemDanhResult;
import com.company.luongchung.models.getLopMonHocTheoDiaDiemResult;
import com.company.luongchung.models.InforSinhVien;
import com.company.luongchung.models.Thongbao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    //lấy thông tin sinh viên.
    @GET("/api/sinhvien/{msv}")
    Call<InforSinhVien> getSV(@Path("msv") String msv);

    //Get lớp môn học tại điểm đó now
    @GET("/api/checkindiadiem/{iddiadiem}")
    Call<List<getLopMonHocTheoDiaDiemResult>> GetLopMonHocTheoDiaDiem(@Path("iddiadiem") String iddiadiem);

    //điểm danh sinh viên.
    @GET("/api/diemdanh/")
    Call<Thongbao> diemdanhsv(@Query("idsinhvien") String idSinhVien,@Query("idbuoihoc") String idBuoiHoc,@Query("token") String token);

    //Get lớp môn học mà sinh viên thuộc lớp đó
    @GET("/api/LopMonHoc/{idsv}")
    Call<ArrayList<LopMonHoc>> getLopMonHoc(@Path("idsv") String idsv);

    //Get lớp môn học mà sinh viên thuộc lớp đó
    @GET("/api/tracuudiemdanh/")
    Call<ArrayList<getTTDiemDanhResult>> getTTLopMonHoc(@Query("idsv") String idsv, @Query("idlmh") String idlmh);

}
