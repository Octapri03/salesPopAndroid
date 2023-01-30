package com.ocprva.salespop.api.pojo.productos.informatica;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Pc extends Producto {
    private TipoPc tipo;

    public Pc(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor, TipoPc tipo) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.tipo = tipo;
    }

    public Pc() {
    }

    public TipoPc getTipo() {
        return tipo;
    }

    public void setTipo(TipoPc tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "tipo=" + tipo +
                '}';
    }
}
