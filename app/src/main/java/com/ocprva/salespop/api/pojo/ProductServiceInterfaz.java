package com.ocprva.salespop.api.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductServiceInterfaz {
    @GET("productos")
    Call<ArrayList<Product>> getProducts();
}
