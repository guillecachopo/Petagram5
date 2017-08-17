package com.example.guill.petagram.menu;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.guill.petagram.R;
import com.example.guill.petagram.javamail.SendMail;

public class ActivityContactar extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText etNombre, etEmail, etMensaje;
    private Button btnComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Boton subir

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etMensaje = (TextInputEditText) findViewById(R.id.etMensaje);
        btnComentario=(Button) findViewById(R.id.btnComentario);


        btnComentario.setOnClickListener(this);
    }

    private void sendEmail() {
        String asunto = etNombre.getText().toString().trim();
        String to = etEmail.getText().toString().trim();
        String mensaje = etMensaje.getText().toString().trim();

        SendMail sm = new SendMail(this, to, asunto, mensaje);
        sm.execute();
    }



    @Override
    public void onClick(View v) {
        sendEmail();
        etNombre.setText("");
        etEmail.setText("");
        etMensaje.setText("");

    }






}
