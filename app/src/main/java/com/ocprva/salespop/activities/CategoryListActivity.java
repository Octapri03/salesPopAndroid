package com.ocprva.salespop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ocprva.salespop.R;
import com.ocprva.salespop.adapters.ProductAdapter;
import com.ocprva.salespop.adapters.ProductListener;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.ArrayList;

public class CategoryListActivity extends AppCompatActivity implements ProductListener {

    private RecyclerView recyclerCategories;
    private ProductAdapter pAdapter;
    public static ArrayList<Product> listaProductos;
    private ProductListener listener;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        recyclerCategories = findViewById(R.id.recyclerCategories);

        this.setProductosListener(this::onProductoSeleccionada);

        ArrayList<Product> productos = (ArrayList<Product>) getIntent().getSerializableExtra("productos");

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        listaProductos = productos;

        recyclerCategories.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCategories.setLayoutManager(layoutManager);

        pAdapter = new ProductAdapter(listaProductos);

        pAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Posición del ítem seleccionado
                int posicion = recyclerCategories.getChildAdapterPosition(view);
                if (listener != null) {
                    listener.onProductoSeleccionada((Product) listaProductos.get(posicion));
                }
            }
        });

        recyclerCategories.setAdapter(pAdapter);
    }

    @Override
    public void onProductoSeleccionada(Product p) {
        Intent i = new Intent(this, DetailProductActivity.class);
        i.putExtra("producto", p);
        startActivity(i);
    }

    public void setProductosListener(ProductListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryListActivity.this, MainActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}