package com.ocprva.salespop.api.pojo.productos.moda;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Ropa extends Producto {
    private Talla talla;
    private Genero genero;

    public Ropa(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor, Talla talla, Genero genero) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.talla = talla;
        this.genero = genero;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "talla=" + talla +
                ", genero=" + genero +
                '}';
    }
}
