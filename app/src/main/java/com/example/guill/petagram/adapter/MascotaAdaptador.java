package com.example.guill.petagram.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guill.petagram.R;
import com.example.guill.petagram.db.ConstructorMascotas;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 13/08/2017.
 */

//Tiene q heredar de RecyclerView.Adapter pq necesitamos adaptador q recibe una colecc de mascotas ViewHolder
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public int contadorLikes = 0;
    public boolean colocar = false;
    Context context;
    public int[] favoritasID = new int [33];
    public int contador = 0;
    public boolean pulsoLike = false;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){ //Contruye la lista de mascotas
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Va a inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        //La linea de codigo anterior es para asociar el layout al RecyclerView
        return new MascotaViewHolder(v); //MascotaViewHolder es el metodo constructor y recibe un view (le pasamos mascota inflado como un view)
                                          //para q empiece a tomarlos como elementos

    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        //Aqui pasamos la lista de mascotas a cada elemento
        //Le damos valor a los valores de la lista mascotas
        final Mascota mascota = mascotas.get(position); //Extrae los elementos segun la posicion
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvNumLikes.setText(String.valueOf(mascotas.get(position).getLikes()));


        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT)
                        .show();
                contadorLikes++;


                //Cuando alguien da like se llama al constructor de contactos
                //(el activity representa el contexto)
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota); //Se inserta el like en la base dedatos
                //Refrescamos el TextView de los likes
                mascotaViewHolder.tvNumLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

                //Ahora tenemos que colocar las mascotas  si cumplen las condiciones,
                //Y, si es así, introduciremos la mascota en nuestras mascotas favoritas
                for (int i=0; i<favoritasID.length; i++) {
                    if (favoritasID[i] == mascota.getId()) {
                        pulsoLike = true;
                    }
                }

                if(favoritasID.length <= 33 && !pulsoLike){
                    favoritasID[contador] = mascota.getId();
                    contador++;
                    constructorMascotas.insertarFavorita(mascota);
                }else if(!pulsoLike){
                    favoritasID[contador] = mascota.getId();
                    constructorMascotas.insertarFavorita(mascota);
                }
                pulsoLike = false;

            }


        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista contactos
        return mascotas.size(); //devuelve el nº de elementos de la lista
    }

    //Tendra una clase estatica para poder usar sus atributos dentro de esta misma clase
    //Una clase ViewHolder nos ayuda a asociar nuestros Views a un objeto
    //Necesitamos herencia de RecyclerView.ViewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Aqui estaran todos mis Views
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        public TextView tvNumLikes;

        public MascotaViewHolder (View itemView) {
            super(itemView);
            //Asocio objetos
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNumLikes = (TextView) itemView.findViewById(R.id.tvContLikes);

        }

    }

}
