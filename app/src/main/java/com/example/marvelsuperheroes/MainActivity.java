package com.example.marvelsuperheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue = null;
    //private String token = null;
    private EditText textoHeroe;
    private EditText nombreHeroe;
    private ImageButton botonBuscar;
    private ListView mListView;
    //ArrayList nombreHeroes = new ArrayList();
    List<String> listaHeroes = new ArrayList<>();
    ArrayAdapter<String> mAdapter;


    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent autentificacion = getIntent();
        //this.token = (String)4566920693344448;

        //mQueue = Volley.newRequestQueue(this);

        botonBuscar = (ImageButton) findViewById(R.id.btn_Buscar);
        textoHeroe = (EditText) findViewById(R.id.tx_Heroe);
        mListView = findViewById(R.id.listView);

        // strHeroe = textoHeroe.getText().toString();


    }

    private void LeerWs(){
        String url = "https://www.superheroapi.com/api.php/4566920693344448/search/"+textoHeroe.getText().toString();


        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    nombreHeroes.add(jsonObject.getString("name"));
                    //System.out.println("Lista de Heroes encontrados: \n" + nombreHeroes);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void irVentanaResultados(View v) {
        Intent ventanaResultados = new Intent(getBaseContext(), ventanaResultados.class);
        //ventanaResultados.putExtra("token",token);
        //ventanaResultados.putExtra("textoHeroe",textoHeroe.getText().toString();
        LeerWs();
        startActivity(ventanaResultados);
    }
}