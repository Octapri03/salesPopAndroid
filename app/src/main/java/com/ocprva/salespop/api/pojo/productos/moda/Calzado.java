package com.ocprva.salespop.api.pojo.productos.moda;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Calzado extends Producto {
    private int talla;

    public Calzado(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor, int talla) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.talla = talla;
    }

    public Calzado() {
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Calzado{" +
                "talla=" + talla +
                '}';
    }
}
