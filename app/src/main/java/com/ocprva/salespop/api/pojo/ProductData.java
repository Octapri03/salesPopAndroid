package com.ocprva.salespop.api.pojo;

import com.ocprva.salespop.api.pojo.productos.informatica.Pc;
import com.ocprva.salespop.api.pojo.productos.informatica.TipoPc;
import com.ocprva.salespop.api.pojo.productos.juegos.Consola;
import com.ocprva.salespop.api.pojo.productos.juegos.TipoConsola;
import com.ocprva.salespop.api.pojo.productos.moda.Calzado;
import com.ocprva.salespop.api.pojo.productos.motor.Coche;
import com.ocprva.salespop.api.pojo.productos.motor.Combustible;

import java.util.ArrayList;
import java.util.Date;

public class ProductData {
    public static ArrayList<Producto> PRODUCTOS = new ArrayList<>();

    static {
        PRODUCTOS.add(new Coche(1, "Opel Corsa", 10000, "Coche muy Practico mu bonito sirve para conducir a sitios", "Valencia", Categoria.MOTOR, new Date(2010, 4, 17), new Usuario(), 1000, 2, 1000, Combustible.GASOLINA));
        PRODUCTOS.add(new Calzado(2, "Vans y vienen", 50, "zapatos de pura calle skater y esas cosas de jovenes", "Playa de Madrid", Categoria.MODA, new Date(2010, 4, 17), new Usuario(), 46));
        PRODUCTOS.add(new Consola(3, "Play Station 5", 800, "La nueva play me la quitan de las manos compra compra ta mu barata", "Bilbao", Categoria.JUEGOS, new Date(2010, 4, 17), new Usuario(), TipoConsola.PLAYSTATION));
        PRODUCTOS.add(new Pc(4, "ASUS Pollo", 900, "Portatil Asus pollo, va que vuela como un pollo, se calienta como un pollo", "Barcelona", Categoria.INFORMATICA, new Date(2010, 4, 17), new Usuario(), TipoPc.PORTATIL));
    }
}