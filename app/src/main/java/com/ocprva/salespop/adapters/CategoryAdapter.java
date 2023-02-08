package com.ocprva.salespop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Producto;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<Producto> listaProductos;

    private View.OnClickListener listener;

    public CategoryAdapter(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_producto, null, false);
// Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        view.setOnClickListener(this);

        return new CategoryAdapter.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolderDatos holder, int position) {
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

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre, categoria, ubicacion, precio;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.nombreProducto);
            this.categoria = itemView.findViewById(R.id.categoriaProducto);
            this.ubicacion= itemView.findViewById(R.id.ubicacionProducto);
            this.precio = itemView.findViewById(R.id.precioProducto);
        }

        public void asignarDatos(Producto producto){
            nombre.setText(producto.getName());
            categoria.setText(producto.getCategoria().toString());
            ubicacion.setText(producto.getUbication());
            precio.setText(String.valueOf(producto.getPrice()));
        }
    }
}
