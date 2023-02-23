package com.ocprva.salespop.api.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario implements Serializable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("num_tel")
    @Expose
    private Object numTel;
    @SerializedName("on_sale")
    @Expose
    private List<Product> onSale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getNumTel() {
        return numTel;
    }

    public void setNumTel(Object numTel) {
        this.numTel = numTel;
    }

    public List<Product> getOnSale() {
        return onSale;
    }

    public void setOnSale(List<Product> onSale) {
        this.onSale = onSale;
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
                '}';
    }
}