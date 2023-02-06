package com.ocprva.salespop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private Producto producto;
    private RecyclerView recyclerProductos;
    private ProductAdapter pAdapter;
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

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerProductos.getContext(),
                        layoutManager.getOrientation());
        recyclerProductos.addItemDecoration(dividerItemDecoration);

        pAdapter = new ProductAdapter(listaProductos);

        pAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Posición del ítem seleccionado
                int posicion = recyclerProductos.getChildAdapterPosition(view);
// Notificación del ítem seleccionado
                Toast.makeText(
                        getContext(),
                        String.valueOf(listaProductos.get(posicion).getPrice()) ,
                        Toast.LENGTH_LONG).show();
                if (listener != null) {
                    listener.onProductoSeleccionada((Producto) listaProductos.get(posicion));
                }
            }
        });

        recyclerProductos.setAdapter(pAdapter);

        return view;
    }

    public void setProductosListener(ProductListener listener) {
        this.listener = listener;
    }
}