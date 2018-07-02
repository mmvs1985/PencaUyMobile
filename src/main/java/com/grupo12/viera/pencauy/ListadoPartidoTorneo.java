package com.grupo12.viera.pencauy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import modelos.ItemPencas;
import modelos.Partido;
import modelos.RespuestaApiTorneo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListadoPartidoTorneo extends AppCompatActivity {

    private static final String ETIQUETA = "RESPUESTAS API";
    private Retrofit retro;
    private ArrayList<Partido> retorno;
    private RecyclerView vistalista;
    private AdaptadorListaPartidoscApuesta adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_partido_torneo);
        retro = ConfigSingletton.getInstance().getRetro();
        ItemPencas item=(ItemPencas)getIntent().getSerializableExtra("itemEnviado");
        //PencaUsuario pu=(PencaUsuario)getIntent().getSerializableExtra("pencaUsuario");
        obtenerDatos(item.getId());
        //defino la lista
        vistalista = (RecyclerView) findViewById(R.id.partidosRv);
        vistalista.setLayoutManager(new LinearLayoutManager(this));
        //creo el arreglo vacio
        retorno = new ArrayList<>();
        //y defino el adaptador, que se encarga de cargar la lista con los datos del array
        adaptador = new AdaptadorListaPartidoscApuesta(retorno,getApplicationContext(),item);
        vistalista.setAdapter(adaptador);
    }

    private void obtenerDatos(String idpenca) {


        //llamo a la interfaz
        ServicioApiListadoPencas interfaz = retro.create(ServicioApiListadoPencas.class);
        //en la interfaz llamo a la funcion obtener lista pata que me de la respuesta de la api
        Call<RespuestaApiTorneo> respuestacall = interfaz.obtenerTorneoPorPenca(idpenca);

        respuestacall.enqueue(new Callback<RespuestaApiTorneo>() {

            @Override
            public void onResponse(Call<RespuestaApiTorneo> call, Response<RespuestaApiTorneo> response) {
                if (response.isSuccessful()) {
                    RespuestaApiTorneo respuesta = response.body();
                    List<Partido> listaRespuesta = respuesta.getPartidos();

                    retorno.addAll(listaRespuesta);
                    Log.i(ETIQUETA, "Respuesta torneo:" + respuesta.getNombre() + " fases: " + respuesta.getFases().size());
                    Log.i(ETIQUETA, "Respuestatorneo partidos:" + listaRespuesta.size()+"retorno"+retorno.size() );
                    for (int i = 0; i < listaRespuesta.size(); i++) {
                        Partido r = listaRespuesta.get(i);
                        Log.i(ETIQUETA, "Respuesta:" + i + " " + r.getIdPartido());
                        //retorno.add(new ItemParticipante(r.getNombre(),r.getApellido(),r.getEmail(),r.getNickname(),r.getPuntos()));
                        //adaptador2.notifyDataSetChanged();
                    }
                    adaptador.notifyDataSetChanged();
                } else {
                    Log.e(ETIQUETA, "en respuesta:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RespuestaApiTorneo> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());
            }

        });
    }
}
