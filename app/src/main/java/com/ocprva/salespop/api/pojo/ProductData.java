package com.ocprva.salespop.api.pojo;

import com.ocprva.salespop.api.pojo.productos.informatica.Pc;
import com.ocprva.salespop.api.pojo.productos.informatica.TipoPc;
import com.ocprva.salespop.api.pojo.productos.juegos.Consola;
import com.ocprva.salespop.api.pojo.productos.juegos.TipoConsola;
import com.ocprva.salespop.api.pojo.productos.moda.Calzado;
import com.ocprva.salespop.api.pojo.productos.motor.Coche;
import com.ocprva.salespop.api.pojo.productos.motor.Combustible;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductData {
    public static ArrayList<Product> PRODUCTOS = new ArrayList<>();
    private static ArrayList<Product> listaProductos;
    static {
        PRODUCTOS = listaProductos;
    }

   /* public static ArrayList<Product> sacarArrayList(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.102:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();
        System.out.println("ESTATIC");
        listaProductos = new ArrayList<>();
        ProductServiceInterfaz service = retrofit.create(ProductServiceInterfaz.class);
        Call<ArrayList<Product>> call = service.getProducts();

        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                System.out.println("Funciona coge");
                listaProductos = response.body();
                System.out.println("desde el static: "+listaProductos);
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                System.out.println("no coge");
            }
        });

        System.out.println("fuera del metodo static: "+listaProductos);

        return listaProductos;
    }*/
}
