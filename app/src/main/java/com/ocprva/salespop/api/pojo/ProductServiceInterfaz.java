package com.ocprva.salespop.api.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductServiceInterfaz {
    @GET("productos")
    Call<ArrayList<Product>> getProducts();

    @POST("productos")
    Call<Product> addProduct(@Body Product product);
}
