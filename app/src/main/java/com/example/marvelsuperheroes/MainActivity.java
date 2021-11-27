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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    //public static List<String> listaHeroes;
    private RequestQueue mQueue = null;
    //private String token = null;
    private EditText textoHeroe;
    private EditText nombreHeroe;
    public EditText pText;
    private ImageButton botonBuscar;
    private ListView mListView;
    //ArrayList nombreHeroes = new ArrayList();
    public static List<String> listaHeroes = new ArrayList<>();
    List<String> listaPrueba = new ArrayList<>();
    ArrayAdapter<String> mAdapter;


    String token = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent autentificacion = getIntent();
        //this.token = (String)4566920693344448;

        //mQueue = Volley.newRequestQueue(this);
        listaPrueba.add("valor prueba 1");
        listaPrueba.add("valor prueba 2");
        listaPrueba.add("valor prueba 3");

        botonBuscar = (ImageButton) findViewById(R.id.btn_Buscar);
        textoHeroe = (EditText) findViewById(R.id.tx_Heroe);
        mListView = findViewById(R.id.listView);
        pText = (EditText) findViewById(R.id.ptext);

        // strHeroe = textoHeroe.getText().toString();


    }
//+textoHeroe.getText().toString()
    public void LeerWs(){
        String url = "https://www.superheroapi.com/api.php/4566920693344448/search/batman";
        listaHeroes.add("Se ejecuto LeerWS");


        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                listaHeroes.add("Antes de try");
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    jsonObject.getString("name");
                    listaHeroes.add(jsonObject.getString("results"));
                    String nombres = jsonObject.getString("results");
                    listaHeroes.add(nombres);
                    pText.setText(jsonObject.getString("name"));
                    listaHeroes.add("Se agregaron los nombres");

                    //System.out.println("Lista de Heroes encontrados: \n" + nombreHeroes);
                } catch (JSONException e) {
                    e.printStackTrace();
                    listaHeroes.add("Hace catch");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listaHeroes.add("Error Response");
            }
        });
        Volley.newRequestQueue(this).add(postRequest);


        /*JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //System.out.println(response);

                        try {
                            //pText.setText(response.getString("name")+ " °C");
                            listaHeroes.add(response.getString("name"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError

            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };;
        mQueue.add(request);*/
    }

    public void irVentanaResultados(View v) {
        Intent ventanaResultados = new Intent(getBaseContext(), ventanaResultados.class);
        LeerWs();
        //ventanaResultados.putExtra("token",token);
        //ventanaResultados.putExtra("lista", String.valueOf(this.listaHeroes));


        startActivity(ventanaResultados);
    }


}