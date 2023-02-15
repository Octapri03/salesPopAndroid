package com.ocprva.salespop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ocprva.salespop.R;
import com.ocprva.salespop.activities.CategoryListActivity;
import com.ocprva.salespop.adapters.ProductAdapter;
import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.ProductData;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.ProductServiceInterfaz;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {

    private RecyclerView recyclerProductos;
    private ProductAdapter pAdapter;
    private CardView motorCard, inmobiliariaCard, juegosCard, informaticaCard, telefoniaCard, modaCard, deportesCard;
    private ArrayList<Product> productos;
    private ArrayList<Product> listaProductos;
    private Intent intent;


    public CategoriesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance() {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        motorCard = view.findViewById(R.id.motorCard);
        inmobiliariaCard = view.findViewById(R.id.inmobiliariaCard);
        juegosCard = view.findViewById(R.id.juegosCard);
        informaticaCard = view.findViewById(R.id.informaticaCard);
        telefoniaCard = view.findViewById(R.id.telefoniaCard);
        modaCard = view.findViewById(R.id.modaCard);
        deportesCard = view.findViewById(R.id.deportesCard);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.102:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

        ProductServiceInterfaz service = retrofit.create(ProductServiceInterfaz.class);
        listaProductos = new ArrayList<>();
        Call<ArrayList<Product>> call = service.getProducts();

        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                System.out.println("funcionaAAAAAAAAAAA");
                listaProductos = response.body();
                ArrayList<CardView> categorias = new ArrayList<>();
                productos = new ArrayList<>();

                categorias.add(motorCard);
                categorias.add(inmobiliariaCard);
                categorias.add(juegosCard);
                categorias.add(informaticaCard);
                categorias.add(telefoniaCard);
                categorias.add(modaCard);
                categorias.add(deportesCard);

                for (CardView card : categorias) {
                    card.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()){
                                case R.id.motorCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("MOTOR")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.inmobiliariaCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("INMOBILIARIA")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.juegosCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("JUEGOS")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.informaticaCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("INFORMATICA")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.telefoniaCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("TELEFONIA")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.modaCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("MODA")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                                case R.id.deportesCard:
                                    productos.clear();
                                    for (Product producto : listaProductos) {
                                        if (producto.getCategoria().getName().equals("DEPORTES")){
                                            productos.add(producto);
                                        }
                                    }
                                    intent = new Intent(getActivity(), CategoryListActivity.class);
                                    intent.putExtra("productos", productos);
                                    startActivity(intent);
                                    break;
                            }
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                System.out.println("POR QUEEEEEEEEEEEEEEEEEEEEEEE");
            }
        });



        return view;
    }
}