package com.ocprva.salespop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.Producto;

public class DetailProductActivity extends AppCompatActivity {

    TextView nombreDetail, precioDetail, ubicacionDetail, categoriaDetail, fechaDetail, descripcionDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        Product producto = (Product) this.getIntent().getSerializableExtra("producto");
        nombreDetail = findViewById(R.id.nombreDetail);
        precioDetail = findViewById(R.id.precioDetail);
        ubicacionDetail = findViewById(R.id.ubicacionDetail);
        categoriaDetail = findViewById(R.id.categoriaDetail);
        fechaDetail = findViewById(R.id.fechaDetail);
        descripcionDetail = findViewById(R.id.descripcionDetail);

        nombreDetail.setText(producto.getName());
        precioDetail.setText(String.valueOf(producto.getPrice()));
        precioDetail.setText(precioDetail.getText() + "€");
        ubicacionDetail.setText(producto.getUbication());
        categoriaDetail.setText(producto.getCategoria().getName());
        fechaDetail.setText(producto.getPublicationDate());
        descripcionDetail.setText(producto.getDescription());

    }
}