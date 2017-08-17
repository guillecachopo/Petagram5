package com.example.guill.petagram.menu;

import com.example.guill.petagram.adapter.FavoritosAdaptador;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public interface IFavoritos {

    public void generarLinearLayoutVertical();

    public FavoritosAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(FavoritosAdaptador adaptador);
}
