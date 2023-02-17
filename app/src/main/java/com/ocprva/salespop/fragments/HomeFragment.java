package com.ocprva.salespop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ocprva.salespop.R;
import com.ocprva.salespop.activities.FailureActivity;
import com.ocprva.salespop.adapters.ProductAdapter;
import com.ocprva.salespop.adapters.ProductListener;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.ProductServiceInterfaz;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment{

    private RecyclerView recyclerProductos;
    private ProductAdapter pAdapter;
    private ProductAdapter filterAdapter;
    public static ArrayList<Product> listaProductos;
    private ProductListener listener;
    private Usuario usuario;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(Usuario user) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        usuario = (Usuario) getArguments().getSerializable("user");

        recyclerProductos = view.findViewById(R.id.recyclerHome);

        recyclerProductos.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerProductos.setLayoutManager(layoutManager);

        System.out.println("home");

        pAdapter = new ProductAdapter(listaProductos);

        pAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Posición del ítem seleccionado
                int posicion = recyclerProductos.getChildAdapterPosition(view);
                if (listener != null) {
                    listener.onProductoSeleccionada((Product) listaProductos.get(posicion));
                }
            }
        });



        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.12:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

        ProductServiceInterfaz service = retrofit.create(ProductServiceInterfaz.class);
        listaProductos = new ArrayList<>();
        Call<ArrayList<Product>> call = service.getProducts();

        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                System.out.println("funcionaAAAAAAAAAAA");
                listaProductos = response.body();
                pAdapter.setData(listaProductos);
                recyclerProductos.setAdapter(pAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Intent intent = new Intent(getActivity(), FailureActivity.class);
                System.out.println("POR QUEEEEEEEEEEEEEEEEEEEEEEE");
                startActivity(intent);
            }
        });

        EditText searchBar = view.findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Implementation for filtering the recycler view goes here
                String query = charSequence.toString().toLowerCase();

                ArrayList<Product> filteredData = new ArrayList<>();

                if (query.equals("")){
                    recyclerProductos.setAdapter(pAdapter);
                }
                else{
                    for (Product data : listaProductos) {
                        if (data.getName().toLowerCase().contains(query)) {
                            filteredData.add(data);
                        }
                    }
                    filterAdapter = new ProductAdapter(filteredData);
                    filterAdapter.notifyDataSetChanged();
                    recyclerProductos.setAdapter(filterAdapter);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return view;
    }

    public void setProductosListener(ProductListener listener) {
        this.listener = listener;
    }
}