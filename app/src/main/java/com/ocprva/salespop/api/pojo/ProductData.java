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
        PRODUCTOS.add(new Coche(1, "Opel Corsa", 10000, "Coche muy Practico mu bonito sirve para conducir a sitios", "Valencia", new Categoria(NombreCategoria.MOTOR), new Date(2010, 4, 17), new Usuario(), 1000, 2, 1000, Combustible.GASOLINA));
        PRODUCTOS.add(new Calzado(2, "Vans y vienen", 50, "zapatos de pura calle skater y esas cosas de jovenes", "Playa de Madrid", new Categoria(NombreCategoria.MODA), new Date(2010, 4, 17), new Usuario(), 46));
        PRODUCTOS.add(new Consola(3, "Play Station 5", 800, "La nueva play me la quitan de las manos compra compra ta mu barata", "Bilbao", new Categoria(NombreCategoria.JUEGOS), new Date(2010, 4, 17), new Usuario(), TipoConsola.PLAYSTATION));
        PRODUCTOS.add(new Pc(4, "ASUS Chicken", 900, "Portatil Asus pollo, va que vuela como un pollo, se calienta como un pollo", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.PORTATIL));
        PRODUCTOS.add(new Pc(5, "Lenovo Pro", 2200, "Portatil Lenovo Pro, con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.PORTATIL));
        PRODUCTOS.add(new Pc(6, "Pc sobremesa HP", 600, "Pc HP, con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.PORTATIL));
        PRODUCTOS.add(new Pc(7, "Pc Sobremesa Dell", 1900, "Pc Sobremesa Dell, con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.SOBREMESA));
        PRODUCTOS.add(new Pc(8, "Pc Sobremesa PCComp", 2200, "Pc Sobremesa PCComp con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.SOBREMESA));
        PRODUCTOS.add(new Pc(9, "Portatil ASUS ROG", 340, "Portatil ASUS ROG, con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA), new Date(2010, 4, 17), new Usuario(), TipoPc.SOBREMESA));
        PRODUCTOS.add(new Pc(10, "Portatil MSI", 1500, "Portatil MSI, con muchas especificaciones como por ejemplo ª", "Barcelona", new Categoria(NombreCategoria.INFORMATICA) , new Date(2010, 4, 17), new Usuario(), TipoPc.PORTATIL));
    }
}
