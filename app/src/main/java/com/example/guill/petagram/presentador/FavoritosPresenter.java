package com.example.guill.petagram.presentador;

import android.content.Context;

import com.example.guill.petagram.db.ConstructorMascotas;
import com.example.guill.petagram.menu.IFavoritos;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public class FavoritosPresenter implements IFavoritosPresenter {
    private IFavoritos iFavoritos;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FavoritosPresenter(IFavoritos iFavoritosView, Context context){
        this.iFavoritos = iFavoritosView;
        this.context = context;
        obtenerFavoritosBaseDatos();
    }

    @Override
    public void obtenerFavoritosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFavoritos();
        mostrarFavoritosRV();
    }

    @Override
    public void mostrarFavoritosRV() {
        iFavoritos.inicializarAdaptadorRV(iFavoritos.crearAdaptador(mascotas));
        iFavoritos.generarLinearLayoutVertical();

    }
}
