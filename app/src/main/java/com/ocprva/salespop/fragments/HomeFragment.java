package com.ocprva.salespop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ocprva.salespop.R;
import com.ocprva.salespop.activities.DetailProductActivity;
import com.ocprva.salespop.activities.MainActivity;
import com.ocprva.salespop.adapters.ProductAdapter;
import com.ocprva.salespop.adapters.ProductListener;
import com.ocprva.salespop.api.pojo.ProductData;
import com.ocprva.salespop.api.pojo.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private RecyclerView recyclerProductos;
    private ProductAdapter pAdapter;
    private ProductAdapter filterAdapter;
    public static ArrayList<Producto> listaProductos;
    private ProductListener listener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listaProductos = ProductData.PRODUCTOS;

        recyclerProductos = view.findViewById(R.id.recyclerHome);

        recyclerProductos.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerProductos.setLayoutManager(layoutManager);

        pAdapter = new ProductAdapter(listaProductos);

        pAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Posición del ítem seleccionado
                int posicion = recyclerProductos.getChildAdapterPosition(view);
                if (listener != null) {
                    listener.onProductoSeleccionada((Producto) listaProductos.get(posicion));
                }
            }
        });

        recyclerProductos.setAdapter(pAdapter);

        EditText searchBar = view.findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Implementation for filtering the recycler view goes here
                String query = charSequence.toString().toLowerCase();

                ArrayList<Producto> filteredData = new ArrayList<>();

                if (query.equals("")){
                    recyclerProductos.setAdapter(pAdapter);
                }
                else{
                    for (Producto data : listaProductos) {
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