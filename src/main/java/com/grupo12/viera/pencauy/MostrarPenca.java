package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import modelos.ItemPencas;
import modelos.PencaUsuario;
import modelos.RespuestaApiPenUsr;
import modelos.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MostrarPenca extends AppCompatActivity {

    TextView pencaId,pencaNombre;
    ItemPencas item;
    Button participarbtn;
    Usuario usrLogeado;
    Retrofit retro;
    PencaUsuario pu;
    boolean retorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_penca);

        retro=ConfigSingletton.getInstance().getRetro();
        Intent inte=getIntent();
        item=(ItemPencas)inte.getSerializableExtra("itemEnviado");
        usrLogeado=ConfigSingletton.getInstance().getUsuarioLogueado();
        pencaId=findViewById(R.id.nopencatv);
        pencaNombre=findViewById(R.id.nombrepencatv);
        pencaId.setText(item.getId());
        pencaNombre.setText(item.getNombre());
        participarbtn=findViewById(R.id.btnParticipar);
        retorno= false;
        obtenerDatos();

        participarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentorneo=new Intent(MostrarPenca.this, ListadoPartidoTorneo.class);
                intentorneo.putExtra("itemEnviado",item);
                intentorneo.putExtra("pencaUsuario",pu);
                startActivity(intentorneo);
            }
        });




    }

    private void obtenerDatos(){
        final String ETIQUETA ="RESP mostrar penca";
        ServicioApiListadoPencas interfaz=retro.create(ServicioApiListadoPencas.class);
        Log.e(ETIQUETA, "itempenca: " + this.item.getId()+"usrLog"+usrLogeado.getId());
        Call<RespuestaApiPenUsr> respuestacall=interfaz.existe_getPencaUsuario(this.item.getId(),usrLogeado.getId());
        respuestacall.enqueue(new Callback<RespuestaApiPenUsr>() {
            @Override
            public void onResponse(Call<RespuestaApiPenUsr> call, Response<RespuestaApiPenUsr> response) {
                if (response.isSuccessful()) {
                    RespuestaApiPenUsr r = response.body();
                    retorno = r.getResultado();
                    Log.e(ETIQUETA, "en respuesta RESULTADOfin: " + String.valueOf(retorno));
                    if (retorno) {
                        Log.e(ETIQUETA, "en respuesta entro: "+r.toString());
                        pu = r.getPencaUsuario();
                        //participarbtn.setVisibility(true);


                    } else {
                        participarbtn.setVisibility(View.INVISIBLE);
                        participarbtn.setClickable(false);
                        Log.e(ETIQUETA, "en respuesta NO entro: " );

                    }
                }
                else {
                    Log.e(ETIQUETA, "en respuesta error: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<RespuestaApiPenUsr> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no participa de esta penca", Toast.LENGTH_SHORT).show();
                Log.e(ETIQUETA, "en falla:" + t.getMessage());
            }
        });





    }
}
