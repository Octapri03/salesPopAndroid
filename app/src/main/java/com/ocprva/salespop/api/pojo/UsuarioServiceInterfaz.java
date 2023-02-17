package com.ocprva.salespop.api.pojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsuarioServiceInterfaz {
    @GET("usuarios")
    Call<ArrayList<Usuario>> getUsuarios();


    @GET("usuarios/login")
    Call<Usuario> validarUsuario(@Query("mail") String mail, @Query("password") String password);

    @POST("usuarios")
    Call<Usuario> addFav(@Query("mail") String mail, @Query("password") String password);
}
