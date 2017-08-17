package com.example.guill.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.guill.petagram.R;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

//Intemediario. Clase clave para estar switcheando la fuente de datos (DB o WebService)
public class ConstructorMascotas {

    private static final int LIKE = 1 ;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    //El primer metodo sera para obtener los datos,
    //los datos siempre deben de venir en un ArrayList

    public ArrayList<Mascota> obtenerDatos(){

        //Conectamos con la base de datos
        BaseDatos db = new BaseDatos(context);
        insertarSieteMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosFavoritos(){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerMascotaFavorita();
    }

    //Creamos un metodo para tener insertadas algunas mascotas
    public void insertarSieteMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Coli");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "BorderCollie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_collie);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Milika");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Pekingese");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_pekingese);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chuky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Yorkshire");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_yorkshire);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Sultan");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "PastorAleman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "12");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_pastoraleman);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chihua");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Chihuahua");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "7");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_chihuahua);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Flufly");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Chouchou");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_chouchou);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Zampi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Bulldog");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EDAD, "8");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ic_perrocomida);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        //Rellenamos el contentValues
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    //Tenemos que obtener los likes de la base de datos y mostrarlos en el TextView
    //Consulta la base de datos y genera la suma de todas las mascotas y devolver la cantidad de likes de una mascota en particular
    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

   public void insertarFavorita(Mascota mascota)
   {
       BaseDatos db = new BaseDatos(context);
       ContentValues contentValues = new ContentValues();
       contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FAVORITAS_ID_MASCOTA, mascota.getId());
       contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
       contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());
       db.insertarMascotaFavorita(contentValues);
   }

}
