package com.ocprva.salespop.api.pojo;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String name;
    private String userName;
    private String mail;
    private String password;
    private int numTel;
    ArrayList<Producto> onSale;
    ArrayList<Producto> favs;

    public Usuario(int id, String name, String userName, String mail, String password, int numTel, ArrayList<Producto> onSale, ArrayList<Producto> favs) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.numTel = numTel;
        this.onSale = onSale;
        this.favs = favs;
    }

    public Usuario() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public ArrayList<Producto> getOnSale() {
        return onSale;
    }

    public void setOnSale(ArrayList<Producto> onSale) {
        this.onSale = onSale;
    }

    public ArrayList<Producto> getFavs() {
        return favs;
    }

    public void setFavs(ArrayList<Producto> favs) {
        this.favs = favs;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", numTel=" + numTel +
                ", onSale=" + onSale +
                ", favs=" + favs +
                '}';
    }
}
