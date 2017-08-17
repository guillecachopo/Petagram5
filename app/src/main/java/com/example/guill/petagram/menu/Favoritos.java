package com.example.guill.petagram.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.guill.petagram.R;
import com.example.guill.petagram.adapter.FavoritosAdaptador;
import com.example.guill.petagram.pojo.Mascota;
import com.example.guill.petagram.presentador.FavoritosPresenter;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity implements IFavoritos {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotas;
    private FavoritosPresenter presenter;


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Boton subir

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        presenter = new FavoritosPresenter(this, getApplicationContext());


    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm); //Para q el recycleview se comporte como un LinearLayout
    }

    @Override
    public FavoritosAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        FavoritosAdaptador adaptador = new FavoritosAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FavoritosAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}

