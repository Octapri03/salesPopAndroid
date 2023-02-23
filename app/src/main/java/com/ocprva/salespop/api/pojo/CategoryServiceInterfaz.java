package com.ocprva.salespop.api.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryServiceInterfaz {
    @GET("categorias")
    Call<ArrayList<Categoria>> getCategorias();
}
