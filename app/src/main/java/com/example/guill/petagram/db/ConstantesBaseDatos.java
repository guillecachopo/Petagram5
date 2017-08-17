package com.example.guill.petagram.db;

/**
 * Created by guill on 16/08/2017.
 */

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS              = "mascota";
    public static final String TABLE_MASCOTAS_ID          = "id";
    public static final String TABLE_MASCOTAS_NOMBRE      = "nombre";
    public static final String TABLE_MASCOTAS_RAZA    = "raza";
    public static final String TABLE_MASCOTAS_EDAD       = "edad";
    public static final String TABLE_MASCOTAS_FOTO        = "foto";

    public static final String TABLE_LIKES_MASCOTA = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA = "id_mascota";
    // public static final String TABLE_LIKES_CONTACT_ID_NUMERO_LIKES = "numero_likes";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes" ;

    public static final String TABLE_MASCOTAS_FAVORITAS  = "mascotas_favoritas";
    public static final String TABLE_MASCOTAS_FAVORITAS_ID = "id";
    public static final String TABLE_MASCOTAS_FAVORITAS_ID_MASCOTA = "id_mascota";





}
