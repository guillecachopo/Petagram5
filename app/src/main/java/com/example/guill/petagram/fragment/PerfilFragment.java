package com.example.guill.petagram.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guill.petagram.R;
import com.example.guill.petagram.adapter.PerfilAdaptador;
import com.example.guill.petagram.pojo.MascotaPerfil;
import com.example.guill.petagram.presentador.IPerfilFragmentPresenter;
import com.example.guill.petagram.presentador.PerfilFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment {

    ArrayList<MascotaPerfil> mascotas;  //Sera de tipo MascotaPerfil porque la clase Mascta muestra el nombre también y MascotaPerfil no
    private RecyclerView listaMascotas;
    private IPerfilFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false); //Equivalente al setContentView (el layout esta en este objeto v)
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);


        presenter = new PerfilFragmentPresenter(this, getContext());
        return v;
    }


    @Override
    public void inicializarAdaptadorRV(PerfilAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2); //2 es el num de columnas
        listaMascotas.setLayoutManager(glm); //Para q el recycleview se comporte como un LinearLayout
    }


    @Override
    public PerfilAdaptador crearAdaptador(ArrayList<MascotaPerfil> mascotas) {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        return adaptador;
    }


}
