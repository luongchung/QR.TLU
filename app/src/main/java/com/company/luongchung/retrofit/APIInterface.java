package com.company.luongchung.retrofit;
import com.company.luongchung.models.getLopMonHocTheoDiaDiemResult;
import com.company.luongchung.models.InforSinhVien;
import com.company.luongchung.models.Thongbao;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("/api/sinhvien/{msv}")
    Call<InforSinhVien> getSV(@Path("msv") String msv);

    @GET("/api/checkindiadiem/{msv}")
    Call<List<getLopMonHocTheoDiaDiemResult>> GetLopMonHocTheoDiaDiem(@Path("msv") String msv);


    @GET("/api/diemdanh/")
    Call<Thongbao> diemdanhsv(@Query("idsinhvien") String idSinhVien,@Query("idbuoihoc") String idBuoiHoc);
}
