package com.ocprva.salespop.api.pojo.productos.juegos;

import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Consola extends Producto {
    private TipoConsola tipoConsola;

    public Consola(int id_prod, String name, int price, String description, String ubication, NombreCategoria categoria, Date fechaPubli, Usuario vendedor, TipoConsola tipoConsola) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.tipoConsola = tipoConsola;
    }

    public Consola() {
    }

    public TipoConsola getTipoConsola() {
        return tipoConsola;
    }

    public void setTipoConsola(TipoConsola tipoConsola) {
        this.tipoConsola = tipoConsola;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "tipoConsola=" + tipoConsola +
                '}';
    }
}
