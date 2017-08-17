package com.example.guill.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guill.petagram.R;
import com.example.guill.petagram.pojo.MascotaPerfil;

import java.util.ArrayList;

/**
 * Created by guill on 15/08/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<MascotaPerfil> mascotas;
    Activity activity;
    public int contadorLikes = 0;

    public PerfilAdaptador(ArrayList<MascotaPerfil> mascotas, Activity activity){ //Contruye la lista de mascotas
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Va a inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil, parent, false);
        //La linea de codigo anterior es para asociar el layout al RecyclerView
        return new PerfilAdaptador.PerfilViewHolder(v); //MascotaViewHolder es el metodo constructor y recibe un view (le pasamos mascota inflado como un view)
        //para q empiece a tomarlos como elementos
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final PerfilAdaptador.PerfilViewHolder mascotaViewHolder, final int position) {
        //Aqui pasamos la lista de mascotas a cada elemento
        //Le damos valor a los valores de la lista mascotas
        final MascotaPerfil mascota = mascotas.get(position); //Extrae los elementos segun la posicion
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNumLikes.setText(String.valueOf(mascotas.get(position).getLikes()));
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista contactos
        return mascotas.size(); //devuelve el nº de elementos de la lista
    }

    //Tendra una clase estatica para poder usar sus atributos dentro de esta misma clase
    //Una clase ViewHolder nos ayuda a asociar nuestros Views a un objeto
    //Necesitamos herencia de RecyclerView.ViewHolder
    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        //Aqui estaran todos mis Views
        private ImageView imgFoto;
        public TextView tvNumLikes;

        public PerfilViewHolder (View itemView) {
            super(itemView);
            //Asocio objetos
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNumLikes = (TextView) itemView.findViewById(R.id.tvContLikes);

        }
    }

}
