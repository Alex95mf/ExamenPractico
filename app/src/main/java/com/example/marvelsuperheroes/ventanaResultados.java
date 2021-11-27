package com.example.marvelsuperheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ventanaResultados extends AppCompatActivity{

    //private RequestQueue mQueue;
    //private String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_resultados);


        //mQueue = Volley.newRequestQueue(this);

        //Intent login = getIntent();
        //this.token = (String)login.getExtras().get("token");
        //revisarSensores();
        //String token = getIntent().getExtras().getString("token");
        //String textoHeroe = getIntent().getExtras().getString("textoHeroe");
        //mostrarHeroes();
        //textview.setText(data);

    }


}