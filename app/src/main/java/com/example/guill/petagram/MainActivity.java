package com.example.guill.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guill.petagram.adapter.PageAdapter;
import com.example.guill.petagram.fragment.PerfilFragment;
import com.example.guill.petagram.fragment.RecyclerViewFragment;
import com.example.guill.petagram.menu.ActivityAcerca;
import com.example.guill.petagram.menu.ActivityContactar;
import com.example.guill.petagram.menu.Favoritos;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar); */

        toolbar=(Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if (toolbar!=null) {
            setSupportActionBar(toolbar);
        }

    }

    //Metemos los fragments en un arraylist
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    //Pasamos la lista de fragments al ViewPager y al tabLayout
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home); //Primera imagen del tabLayout
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);   //Segunda
    }

    //-----MENU OPTIONS---------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //Controlar opciones menu:

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //El item del menu seleccionado

        switch (item.getItemId()){

            case R.id.imgvFavourite:
                Intent ii = new Intent(this,Favoritos.class);
                startActivity(ii);
                break;

            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContactar.class);
                startActivity(intent);
                break;

            case R.id.mAcerca:
                Intent i = new Intent(this, ActivityAcerca.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }





}
