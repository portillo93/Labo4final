package com.example.rafaj.fragmentapp;

import java.io.Serializable;

public class informa implements Serializable {
    String Nombre;
    String Distancia;
    String Satelites;
    String Imagen;


    public informa(String nombre,String imagen,String distancia,String satelites) {
        Nombre = nombre;
        Imagen = imagen;
        Distancia = distancia;
        Satelites = satelites;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }
    public String getSatelites() {
        return Satelites;
    }

    public void setSatelites(String satelites) {
        Satelites = satelites;
    }

}


