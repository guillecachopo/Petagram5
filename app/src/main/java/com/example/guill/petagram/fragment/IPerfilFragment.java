package com.example.guill.petagram.fragment;

import com.example.guill.petagram.adapter.PerfilAdaptador;
import com.example.guill.petagram.pojo.MascotaPerfil;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public interface IPerfilFragment {

    public void generarGridLayout();

    public PerfilAdaptador crearAdaptador(ArrayList<MascotaPerfil> mascotas);

    public void inicializarAdaptadorRV(PerfilAdaptador adaptador);


}
