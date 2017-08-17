package com.example.guill.petagram.pojo;

/**
 * Created by guill on 15/08/2017.
 */


//Clase creada para que no aparezca el nombre de la mascota en las fotos de su perfil, es similar a Mascota
public class MascotaPerfil {

    private int foto;
    private int likes;

    public MascotaPerfil(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }


}
