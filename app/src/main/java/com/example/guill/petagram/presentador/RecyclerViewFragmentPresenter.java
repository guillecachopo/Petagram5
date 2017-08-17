package com.example.guill.petagram.presentador;

import android.content.Context;

import com.example.guill.petagram.db.ConstructorMascotas;
import com.example.guill.petagram.fragment.IRecyclerViewFragment;
import com.example.guill.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by guill on 16/08/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    public ArrayList<Mascota> mascotas;

    //Recibe una instancia del modelo
    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        //Obtenemos los datos de la DB:
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        //Aqui separamos la fuente de datos con el constructor de los datos
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        //El adaptador recibe la lista previamente creada
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        //Hay que definir de que forma queremos ver el RecylerView
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
