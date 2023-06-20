package com.example.ilham_projek_akhir_kba.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfiguration {

    static String BASE_URL = "http://himtiumt.org/backend_kelompok_belajar_android/index.php/API_tugas_akhir/";

    public static Retrofit getApiHit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiHIt service = getApiHit().create(ApiHIt.class);
}
