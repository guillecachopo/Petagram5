package com.example.guill.petagram.presentador;

import android.content.Context;

import com.example.guill.petagram.R;
import com.example.guill.petagram.fragment.IPerfilFragment;
import com.example.guill.petagram.pojo.MascotaPerfil;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragment iPerfilFragment;
    private Context context;
    public ArrayList<MascotaPerfil> mascotas;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context){
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        //Obtenemos los datos de la DB:
        inicializarListaMascotas();
        mostrarMascotasRV();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<MascotaPerfil>();

        mascotas.add(new MascotaPerfil(R.drawable.ic_collie2, 5));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie, 7));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie3,4));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie5, 5));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie6,5));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie7, 7));
        mascotas.add(new MascotaPerfil(R.drawable.ic_collie8,8));
    }


    @Override
    public void mostrarMascotasRV() {
        //El adaptador recibe la lista previamente creada
        iPerfilFragment.inicializarAdaptadorRV(iPerfilFragment.crearAdaptador(mascotas));
        //Hay que definir de que forma queremos ver el RecylerView
        iPerfilFragment.generarGridLayout();
    }


}
