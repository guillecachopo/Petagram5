package com.example.guill.petagram.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.guill.petagram.R;

public class ActivityAcerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Boton subir
    }
}
