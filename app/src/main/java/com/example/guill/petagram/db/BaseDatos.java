package com.example.guill.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        //El nombre de la DB y la version los manejaremos en una clase auxiliar
        //que funcionara como una clase de constantes con datos principales de la DB
        //como el nombre, la version, el nombre de las tablas...
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE      + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_RAZA    + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_EDAD       + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO        + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")"+
                ")";

        String queryCrearTablaMascotasFavoritas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + " (" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaMascotasFavoritas);

    }

    //El metodo onUpgrade se ejecutara solo si necesitamos reestructurar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS);

        onCreate(db);
    }

    //Metodo para eecutar una consulta a la base de datos
    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        //Empezamos a abrir la base de datos
        SQLiteDatabase db = this.getWritableDatabase();
        //Manejamos un rawQuery pq necesitamos q devuelva la coleccion de datos q consultó
        db.rawQuery(query, null); //null hace ref a q no tenemos ningun filtro
        Cursor registros = db.rawQuery(query, null);
        //Recorremos los registros con un while
        //Cuando no haya mas registros salimos del bucle. Aqui llenamos el objeto contactos
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0)); //recibe el indice de la columna. El id es el 0
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setEdad(registros.getString(3));
            mascotaActual.setFoto(registros.getInt(4));

            //Se rellena la lista con tantas mascotas tengamos
            mascotas.add(mascotaActual);

            //Para recuperar los likes  al iniciar la app
            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            } else {
                mascotaActual.setLikes(0);
            }
        }

        db.close();

        return mascotas;
    }

    //el ContentValues es para insertar una mascota
    public void insertarMascota(ContentValues contentValues){
        //Abrimos la db
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues); //El valor del campo y el campo es lo que tendra el contentValue
        //La cerramos
        db.close();;
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    //Devuelve la cantidad de likes
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        //Suma de los valores de un campo (likes)
        //Es decir, la suma de likes de una mascota en particular
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "="+mascota.getId();

        //Ejecutamos el query y recuperamos los datos en un cursor
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        //Una vez q tenemos los recursos iteramos
        //Como hay solo un dato ponemos un if en vez de un while
        //Sera un unico dato, un unico campo y un unico registro
        if (registros.moveToNext()){
            likes = registros.getInt(0); //Indice 0 de la columna (el unico q manejamos)
        }

        db.close();
        return likes;
    }

    public void insertarMascotaFavorita(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS, null, contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerMascotaFavorita() {
        //Creamos ArrayList de mascotas vacío inicialmente
        ArrayList<Mascota> mascotas = new ArrayList<>();

        //El limite de mascotas favoritas sera 5 y tenemos que definirlo
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS + " ORDER BY "
                                        + ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS_ID + " DESC LIMIT 5 ";

        //Ejecutamos el query y recuperamos los datos en un cursor
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        //Bucle while para ir iterando
        while (registros.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0)); //El ID es el parametro 0
            mascota.setNombre(registros.getString(2)); //El nombre es el parametro 2
            mascota.setFoto(registros.getInt(3));   //La foto es el parametro 3
            //Añadimos la mascota
            mascotas.add(mascota);
        }

        db.close();
        return mascotas;
    }

}
