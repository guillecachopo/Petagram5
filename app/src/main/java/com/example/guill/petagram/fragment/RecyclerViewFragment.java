package com.example.guill.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guill.petagram.R;
import com.example.guill.petagram.adapter.MascotaAdaptador;
import com.example.guill.petagram.pojo.Mascota;
import com.example.guill.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.example.guill.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false); //Equivalente al setContentView (el layout esta en este objeto v)
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //Hay que llamar al presentador, pasamos esta actividad y un contexto
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm); //Para q el recycleview se comporte como un LinearLayout
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }


    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }


}
