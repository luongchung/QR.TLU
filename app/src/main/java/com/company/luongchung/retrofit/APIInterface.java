package com.company.luongchung.retrofit;
import com.company.luongchung.models.InforSinhVien;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/api/sinhvien/{msv}")
    Call<InforSinhVien> getSV(@Path("msv") String msv);
}
