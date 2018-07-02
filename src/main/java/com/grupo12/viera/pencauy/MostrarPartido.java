package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import modelos.ItemPencas;
import modelos.Partido;
import modelos.PencaUsuario;
import modelos.RespuestaApiBooleana;
import modelos.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MostrarPartido extends AppCompatActivity {

    //TextView pencaId,pencaNombre;
    Partido item;
    ItemPencas penca;
    Button participarbtn;
    Usuario usrLogeado;
    Retrofit retro;
    PencaUsuario pu;
    TextView  noPartido, fechaPartido, equipoLoc,equipoVis;
    EditText golesLocET, golesvisET;
    Button btnEnv;
    RadioGroup rg;
    RadioButton rbloc,rbvis;
    //boolean retorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_partido);

        retro=ConfigSingletton.getInstance().getRetro();
        Intent inte=getIntent();
        item=(Partido)inte.getSerializableExtra("itemEnviado");
        penca=(ItemPencas)inte.getSerializableExtra("penca");
        usrLogeado=ConfigSingletton.getInstance().getUsuarioLogueado();
        //pencaId=findViewById(R.id.nopencatv);
        //pencaNombre=findViewById(R.id.nombrepencatv);
        //pencaId.setText(item.getId());
        //encaNombre.setText(item.getNombre());
        //retorno= false;
        golesLocET =findViewById(R.id.golesLocET2);
        golesvisET=findViewById(R.id.golesvisET2);
        noPartido=findViewById(R.id.noPartidotv2);
        fechaPartido=findViewById(R.id.fechaPartidotv2);
        btnEnv=findViewById(R.id.btnenv2);
        rbvis=findViewById(R.id.visitaRB2);
        rbloc=findViewById(R.id.locRb2);
        equipoLoc=findViewById(R.id.equipoLoctv2);
        equipoVis=findViewById(R.id.equipovistv2);
        noPartido.setText(item.getIdPartido().toString());
        fechaPartido.setText(item.getPartidoFecha());
        equipoLoc.setText(item.getPartidoEquipoLocal());
        equipoVis.setText(item.getPartidoEquipoVisita());


        btnEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String equipoPasa;
                if(Integer.valueOf(golesLocET.getText().toString())>Integer.valueOf(golesvisET.getText().toString())) {
                    equipoPasa=equipoVis.getText().toString();
                    Log.e("Apuesta","ganalocal");
                }
                else{
                    if(Integer.valueOf(golesLocET.getText().toString())!=Integer.valueOf(golesvisET.getText().toString()))
                    {equipoPasa=equipoVis.getText().toString();
                    }
                    else {
                        if(rbloc.isChecked()){
                            equipoPasa=equipoVis.getText().toString();}

                        else {
                            equipoPasa=equipoVis.getText().toString();
                        }

                    }
                }
                realizarApuesta(Integer.valueOf(golesLocET.getText().toString()),Integer.valueOf(golesvisET.getText().toString()),equipoPasa,item.getIdPartido(),Integer.valueOf(ConfigSingletton.getInstance().getUsuarioLogueado().getId()),Integer.valueOf(penca.getId()));
                /*Intent intentorneo=new Intent(MostrarPartido.this, ListadoPartidoTorneo.class);
                intentorneo.putExtra("itemEnviado",item);
                intentorneo.putExtra("pencaUsuario",pu);
                startActivity(intentorneo);*/
            }
        });




    }

    private void realizarApuesta(int golesLocal,int golesVisita,String equipopasa,int idpartido,int idUsr, int idPenca ) {

        final String ETIQUETA = "Resp API apuesta";
        Retrofit retro=ConfigSingletton.getInstance().getRetro();
        ServicioApiListadoPencas interfaz = retro.create(ServicioApiListadoPencas.class);
        Call<RespuestaApiBooleana> respuestacall = interfaz.realizarApuesta( golesLocal,golesVisita,equipopasa,idpartido,idUsr,idPenca);
        respuestacall.enqueue(new Callback<RespuestaApiBooleana>() {
            @Override
            public void onResponse(Call<RespuestaApiBooleana> call, Response<RespuestaApiBooleana> response) {

                if (response.isSuccessful()) {
                    Log.e(ETIQUETA, "resp solicita part: " + response.body().getResultado());
                    RespuestaApiBooleana r = response.body();
                    String resultado = r.getResultado();
                    if (resultado.equals("true")) {
                        Log.e(ETIQUETA, "resp srest: " + response.body().getResultado());
                        Toast.makeText(getApplicationContext(),r.getUsuario().getNombre()+" Apuesta Correcta",Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e(ETIQUETA, "resp no: " + response.body().getResultado());
                        Toast.makeText(getApplicationContext(),"Apuesta Incorrecta",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Toast.makeText(contexto, "soliciud incorrecta", Toast.LENGTH_SHORT);
                }
            }


            @Override
            public void onFailure(Call<RespuestaApiBooleana> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());

            }
        });


    }






}
