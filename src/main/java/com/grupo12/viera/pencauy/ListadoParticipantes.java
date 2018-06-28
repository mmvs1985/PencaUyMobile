package com.grupo12.viera.pencauy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import modelos.ItemParticipante;
import modelos.Respuesta;
import modelos.RespuestaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListadoParticipantes extends AppCompatActivity {

    private static final String ETIQUETA ="RESPUESTAS API";
    private Retrofit retro;
    private ArrayList<ItemParticipante> retorno;
    private ListView vistalista2;
    private AdaptadorParticipantes adaptador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_participantes);
        //creo el conextor retrofit
        retro = ConfigSingletton.getInstance().getRetro();
        //ejecuto el llamado
        obtenerDatos2();
        //defino la lista
        vistalista2=(ListView)findViewById(R.id.listPart);
        //creo el arreglo vacio
        retorno=new ArrayList<>();
        //y defino el adaptador, que se encarga de cargar la lista con los datos del array
        adaptador2=new AdaptadorParticipantes(getApplicationContext(),retorno);
        vistalista2.setAdapter(adaptador2);
    }

    private void obtenerDatos2(){


        //llamo a la interfaz
        ServicioApiListadoParticipantes interfaz =retro.create(ServicioApiListadoParticipantes.class);
        //en la interfaz llamo a la funcion obtener lista pata que me de la respuesta de la api
        Call<RespuestaApi> respuestacall=interfaz.obtenerLista();

        respuestacall.enqueue(new Callback<RespuestaApi>() {

            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                if (response.isSuccessful()) {
                    RespuestaApi respuesta = response.body();
                    ArrayList<Respuesta> listaRespuesta = respuesta.getResults();
                    for (int i = 0; i < listaRespuesta.size(); i++) {
                        Respuesta r = listaRespuesta.get(i);
                        Log.i(ETIQUETA, "Respuesta:" + i + " " + r.getNombre());
                        retorno.add(new ItemParticipante(r.getNombre(),r.getApellido(),r.getEmail(),r.getNickname(),r.getPuntos()));
                        adaptador2.notifyDataSetChanged();
                    }
                } else {
                    Log.e(ETIQUETA, "en respuesta:" + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());
            }

        });

    }

}
