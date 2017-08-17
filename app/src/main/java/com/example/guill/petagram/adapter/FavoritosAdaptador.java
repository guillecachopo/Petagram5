package com.example.guill.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guill.petagram.R;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public class FavoritosAdaptador extends RecyclerView.Adapter<FavoritosAdaptador.FavoritosViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public FavoritosAdaptador(ArrayList<Mascota> mascotas, Activity activity) { //Contruye la lista de mascotas favoritas
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Va a inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public FavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        //La linea de codigo anterior es para asociar el layout al RecyclerView
        return new FavoritosAdaptador.FavoritosViewHolder(v); //MascotaViewHolder es el metodo constructor y recibe un view (le pasamos mascota inflado como un view)
        //para q empiece a tomarlos como elementos
    }

    @Override
    public void onBindViewHolder(final FavoritosViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvNumLikes.setText(String.valueOf(""));

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FavoritosViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        public TextView tvNumLikes;

        public FavoritosViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNumLikes = (TextView) itemView.findViewById(R.id.tvContLikes);

        }
    }

}
