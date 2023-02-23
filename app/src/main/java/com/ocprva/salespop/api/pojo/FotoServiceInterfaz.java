package com.ocprva.salespop.api.pojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FotoServiceInterfaz {
    @POST("fotos")
    Call<Foto> addFoto(@Body Foto foto);
}
