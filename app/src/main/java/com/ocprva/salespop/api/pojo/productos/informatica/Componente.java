package com.ocprva.salespop.api.pojo.productos.informatica;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Componente extends Producto {
    public Componente(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
    }

    public Componente() {
    }
}
