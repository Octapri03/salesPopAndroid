package com.ocprva.salespop.api.pojo;

import java.util.Date;

public class Producto {
    private int id_prod;
    private String name;
    private int price;
    private String description;
    private String ubication;
    private Categoria categoria;
    private Date fechaPubli;
    private Usuario vendedor;

    public Producto(int id_prod, String name, int price, String description, String ubication, Categoria categoria, Date fechaPubli, Usuario vendedor) {
        this.id_prod = id_prod;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ubication = ubication;
        this.categoria = categoria;
        this.fechaPubli = fechaPubli;
        this.vendedor = vendedor;
    }

    public Producto() {
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(Date fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_prod=" + id_prod +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", ubication='" + ubication + '\'' +
                ", categoria=" + categoria +
                ", fechaPubli=" + fechaPubli +
                ", vendedor=" + vendedor +
                '}';
    }
}
