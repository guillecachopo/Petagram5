package com.example.guill.petagram.pojo;

/**
 * Created by guill on 12/08/2017.
 */

public class Mascota {

    private int id;
    private String nombre;
    private String raza;
    private String edad;

    private int foto;
    private int likes;

    public Mascota(int foto, String nombre, String raza, String edad, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.likes = likes;
    }

    public Mascota() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
