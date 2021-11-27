package com.example.marvelsuperheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class ventanaResultados extends AppCompatActivity{

    //private RequestQueue mQueue;
    //private String token = "";
    ListView listView2;
    public static ListView listView;
    List<String> listaPrueba2 = new ArrayList<>();
    //public List<String> listaDeHeroes = new ArrayList<>();
    ArrayAdapter<String> mAdapter2;
    ArrayAdapter<String> mAdapter;
    public static List<String> listaDeHeroes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_resultados);



        listView = findViewById(R.id.listView);

        listaPrueba2.add("valor prueba 1");
        listaPrueba2.add("valor prueba 2");
        listaPrueba2.add("valor prueba 3");
        MainActivity.listaHeroes.add("pruebita");

        //Intent intent = getIntent();
        //Bundle bundle = intent.getExtras();

        //if(bundle != null){
            //listaDeHeroes = bundle.getStringArrayList();
        //}

        //mAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaPrueba2);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MainActivity.listaHeroes);
        listView.setAdapter(mAdapter);
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