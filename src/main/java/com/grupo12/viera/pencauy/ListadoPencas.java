package com.grupo12.viera.pencauy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import modelos.ItemPencas;
import modelos.RespuestaApiPencas;
import modelos.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//modelos
//retrofit

public class ListadoPencas extends AppCompatActivity {

    private static final String ETIQUETA ="RESP API pencas";
    private Retrofit retro;
    private ArrayList<ItemPencas> arrai;
    private ListView vistalista;
    private AdaptadorListaPenca adaptador;
    private Usuario usuarioLoguado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        usuarioLoguado= ConfigSingletton.getInstance().getUsuarioLogueado();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pencas);
        //creo el conextor retrofit
        retro = ConfigSingletton.getInstance().getRetro();
        //ejecuto el llamado
        obtenerDatos();
        //defino la lista
        vistalista=(ListView)findViewById(R.id.listPencas);
        //creo el arreglo vacio
        arrai=new ArrayList<ItemPencas>();
        //y defino el adaptador, que se encarga de cargar la lista con los datos del array
        adaptador=new AdaptadorListaPenca(getApplicationContext(),arrai,retro,usuarioLoguado.getId());

        vistalista.setAdapter(adaptador);
    }


    private void obtenerDatos(){
        //llamo a la interfaz
        ServicioApiListadoPencas interfaz =retro.create(ServicioApiListadoPencas.class);
        //en la interfaz llamo a la funcion obtener lista pata que me de la respuesta de la api
        Call<RespuestaApiPencas> respuestacall=interfaz.obtenerLista();

        respuestacall.enqueue(new Callback<RespuestaApiPencas>() {

            @Override
            public void onResponse(Call<RespuestaApiPencas> call, Response<RespuestaApiPencas> response) {
                if (response.isSuccessful()) {
                    RespuestaApiPencas respuesta = response.body();
                    ArrayList<ItemPencas> listaRespuesta = respuesta.getResultado();
                    for (int i = 0; i < listaRespuesta.size(); i++) {
                        ItemPencas r = listaRespuesta.get(i);
                       Log.i(ETIQUETA, "Respuesta:" + i + " " + r.getNombre());
                        arrai.add(r);
                        adaptador.notifyDataSetChanged();
                    }
                } else {
                    Log.e(ETIQUETA, "en respuesta:" + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<RespuestaApiPencas> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());
            }

        });

    }
}
