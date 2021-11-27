package com.example.marvelsuperheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue = null;
    //private String token = null;
    private EditText textoHeroe;
    private ImageButton botonBuscar;

    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent autentificacion = getIntent();
        this.token = (String)4566920693344448;

        mQueue = Volley.newRequestQueue(this);

        botonBuscar = (ImageButton) findViewById(R.id.btn_Buscar);
        textoHeroe = (EditText) findViewById(R.id.tx_Heroe);

        //String strHeroe = textoHeroe.getText().toString();


    }

    public void irVentanaResultados(View v) {
        Intent ventanaResultados = new Intent(getBaseContext(), MainActivity.class);
        ventanaResultados.putExtra("token",token);
        ventanaResultados.putExtra("textoHeroe",textoHeroe.getText().toString();
        startActivity(ventanaResultados);
    }
}