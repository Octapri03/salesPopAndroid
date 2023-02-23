package com.ocprva.salespop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocprva.salespop.R;
import com.ocprva.salespop.activities.CategoryListActivity;
import com.ocprva.salespop.activities.LoginActivity;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.ProductServiceInterfaz;
import com.ocprva.salespop.api.pojo.Usuario;

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

    private CardView motorCard, inmobiliariaCard, juegosCard, informaticaCard, telefoniaCard, modaCard, deportesCard;
    private ArrayList<Product> productos;
    private ArrayList<Product> listaProductos;
    private Intent intent;
    private Usuario usuario;


    public CategoriesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(Usuario user) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putSerializable("user", user);
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

        usuario = (Usuario) getArguments().getSerializable("user");

        motorCard = view.findViewById(R.id.motorCard);
        inmobiliariaCard = view.findViewById(R.id.inmobiliariaCard);
        juegosCard = view.findViewById(R.id.juegosCard);
        informaticaCard = view.findViewById(R.id.informaticaCard);
        telefoniaCard = view.findViewById(R.id.telefoniaCard);
        modaCard = view.findViewById(R.id.modaCard);
        deportesCard = view.findViewById(R.id.deportesCard);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.12:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

        ProductServiceInterfaz service = retrofit.create(ProductServiceInterfaz.class);
        listaProductos = new ArrayList<>();
        Call<ArrayList<Product>> call = service.getProducts();

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
                    call.enqueue(new Callback<ArrayList<Product>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                            switch (v.getId()) {
                                case R.id.motorCard:
                                    startCategory(response.body(), "MOTOR");
                                    break;
                                case R.id.inmobiliariaCard:
                                    startCategory(response.body(), "INMOBILIARIA");
                                    break;
                                case R.id.juegosCard:
                                    startCategory(response.body(), "JUEGOS");
                                    break;
                                case R.id.informaticaCard:
                                    startCategory(response.body(), "INFORMATICA");
                                    break;
                                case R.id.telefoniaCard:
                                    startCategory(response.body(), "TELEFONIA");
                                    break;
                                case R.id.modaCard:
                                    startCategory(response.body(), "MODA");
                                    break;
                                case R.id.deportesCard:
                                    startCategory(response.body(), "DEPORTES");
                                    break;
                            }

                        }

                        @Override
                        public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                            conFailed();
                        }
                    });
                }
                });
        }
        return view;
    }

    public void conFailed(){
        System.out.println("Connection Failed");
        intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    public void startCategory(ArrayList<Product> listaRecibida, String categoria){
        productos.clear();
        listaProductos = listaRecibida;
        for (Product producto : listaProductos) {
            if (producto.getCategoria().getName().equals(categoria)){
                productos.add(producto);
            }
        }
        intent = new Intent(getActivity(), CategoryListActivity.class);
        intent.putExtra("productos", productos);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
