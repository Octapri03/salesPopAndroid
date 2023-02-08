package com.ocprva.salespop.api.pojo.productos.juegos;

import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Juego extends Producto {
    public Juego(int id_prod, String name, int price, String description, String ubication, NombreCategoria categoria, Date fechaPubli, Usuario vendedor) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
    }
}
