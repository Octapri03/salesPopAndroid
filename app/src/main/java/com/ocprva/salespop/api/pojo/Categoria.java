package com.ocprva.salespop.api.pojo;

import java.io.Serializable;

public class Categoria implements Serializable {
    NombreCategoria nombre;

    public Categoria(NombreCategoria nombre) {
        this.nombre = nombre;
    }

    public NombreCategoria getNombre() {
        return nombre;
    }

    public void setNombre(NombreCategoria nombre) {
        this.nombre = nombre;
    }
}
