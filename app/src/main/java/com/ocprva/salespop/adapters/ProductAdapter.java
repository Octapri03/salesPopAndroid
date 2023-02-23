package com.ocprva.salespop.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<Product> listaProductos;

    private View.OnClickListener listener;

    public ProductAdapter(ArrayList<Product> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_producto, null, false);
// Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaProductos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public void setData(ArrayList<Product> data) {
        this.listaProductos = data;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre, categoria, ubicacion, precio;
        ImageView ivProducto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.nombreProducto);
            this.categoria = itemView.findViewById(R.id.categoriaProducto);
            this.ubicacion= itemView.findViewById(R.id.ubicacionProducto);
            this.precio = itemView.findViewById(R.id.precioProducto);
            this.ivProducto = itemView.findViewById(R.id.ivProducto);
        }

        public void asignarDatos(Product producto){
            nombre.setText(producto.getName());
            categoria.setText(producto.getCategoria().getName());
            ubicacion.setText(producto.getUbication());
            precio.setText(String.valueOf(producto.getPrice())+"€");

            String base64String = producto.getFoto().get(0).getUrlImagen(); // The Base64 encoded string
            byte[] decodedBytes = Base64.decode(base64String, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
            ivProducto.setImageBitmap(bitmap);
        }
    }
}
