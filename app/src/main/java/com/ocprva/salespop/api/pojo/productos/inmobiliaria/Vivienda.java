package com.ocprva.salespop.api.pojo.productos.inmobiliaria;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Vivienda extends Producto {
    private int metrosCuadrados;
    private int dormitorios;
    private int banyos;
    private TipoVivienda tipo;

    public Vivienda(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor, int metrosCuadrados, int dormitorios, int banyos, TipoVivienda tipo) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.metrosCuadrados = metrosCuadrados;
        this.dormitorios = dormitorios;
        this.banyos = banyos;
        this.tipo = tipo;
    }

    public Vivienda() {
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    public int getBanyos() {
        return banyos;
    }

    public void setBanyos(int banyos) {
        this.banyos = banyos;
    }

    public TipoVivienda getTipo() {
        return tipo;
    }

    public void setTipo(TipoVivienda tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vivienda{" +
                "metrosCuadrados=" + metrosCuadrados +
                ", dormitorios=" + dormitorios +
                ", banyos=" + banyos +
                ", tipo=" + tipo +
                '}';
    }
}
