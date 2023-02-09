package com.ocprva.salespop.api.pojo.productos.motor;

import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.util.Date;

public class Coche extends Producto {
    private int kms;
    private int plazas;
    private int cv;
    private Combustible combustible;

    public Coche(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor, int kms, int plazas, int cv, Combustible combustible) {
        super(id_prod, name, price, description, ubication, categoria, fechaPubli, vendedor);
        this.kms = kms;
        this.plazas = plazas;
        this.cv = cv;
        this.combustible = combustible;
    }

    public Coche() {
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "kms=" + kms +
                ", plazas=" + plazas +
                ", cv=" + cv +
                ", combustible=" + combustible +
                '}';
    }
}
