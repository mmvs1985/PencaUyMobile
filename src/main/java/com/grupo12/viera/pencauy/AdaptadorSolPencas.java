package com.grupo12.viera.pencauy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import modelos.ItemPencas;
import modelos.RespuestaApiBooleana;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by HP Usuario on 11/6/2018.
 */

public class AdaptadorSolPencas extends BaseAdapter {
    private static final String ETIQUETA = "RESP. API Sol pencas";
    private ArrayList<ItemPencas> listItems;
    private Context contexto;
    private Retrofit retro;
    private String idUsuarioLog;
    private boolean retornoSol;
    private boolean retornoBor;


    public AdaptadorSolPencas(Context contexto, ArrayList<ItemPencas> listItems, Retrofit retro, String  idUsuarioLog) {
        this.listItems = listItems;
        this.contexto = contexto;
        this.retro= retro;
        this.idUsuarioLog=idUsuarioLog;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) { return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        retornoSol =false;
        retornoBor=false;
        final ItemPencas item = (ItemPencas) getItem(i);
        view = LayoutInflater.from(contexto).inflate(R.layout.item_penca, null);
        TextView tvid = (TextView) view.findViewById(R.id.idtv);
        TextView tvnombre = (TextView) view.findViewById(R.id.nombretv);
        TextView tvprecio = (TextView) view.findViewById(R.id.preciotv);
        TextView tvadminfront = (TextView) view.findViewById(R.id.adminfront);
        TextView tvtorneo = (TextView) view.findViewById(R.id.torneo);
        TextView tvestilo = (TextView) view.findViewById(R.id.estilo);

        tvid.setText(item.getId());
        tvnombre.setText(item.getNombre());
        tvprecio.setText(item.getPrecio());
        tvadminfront.setText(item.getAdminfront());
        tvtorneo.setText(item.getTorneo());
        tvestilo.setText(item.getEstilo());
        Log.e("penca:","fue solicitada: "+item.getFueSolicitada());
        /*if(item.getFueSolicitada().equals("true")){
            Log.e("penca:"," entro en fue solicitada");
            check.setChecked(true);
            if (check.isChecked()){
                Log.e("penca:"," seteada solicitada");
            }

        }*/
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                    if (!view.isSelected()){
                        solicitarParticipacion(item.getId(), idUsuarioLog);
                        if (retornoSol) {
                            view.setSelected(true);
                        }
                        //Toast.makeText(contexto, "toque" + item.getId() + "  usuario " + idUsuarioLog, Toast.LENGTH_SHORT).show();
                    }
                    else {

                        borrarParticipacion(item.getId(), idUsuarioLog);
                        if (retornoBor) {
                            view.setSelected(false);
                        }
                    }

            }
        });




        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }


    private void solicitarParticipacion(String pencaId, String usuarioId) {
        ServicioApiListadoPencas interfaz = retro.create(ServicioApiListadoPencas.class);
        Call<RespuestaApiBooleana> respuestacall = interfaz.solicitarParticipacion(pencaId, usuarioId);
        respuestacall.enqueue(new Callback<RespuestaApiBooleana>() {
            @Override
            public void onResponse(Call<RespuestaApiBooleana> call, Response<RespuestaApiBooleana> response) {

                if (response.isSuccessful()) {
                    Log.e(ETIQUETA, "resp solicita part: " + response.body().getResultado());
                    RespuestaApiBooleana r = response.body();
                    String resultado = r.getResultado();
                    if (resultado.equals("true")) {
                        Log.e(ETIQUETA, "resp srest: " + response.body().getResultado());
                        Toast.makeText(contexto , "soliciud correcta", Toast.LENGTH_SHORT).show();
                        retornoSol =true;
                    } else {
                        Toast.makeText(contexto, "soliciud no exitosa", Toast.LENGTH_SHORT);
                    }
                } else {
                    Toast.makeText(contexto, "soliciud incorrecta", Toast.LENGTH_SHORT);
                }
            }


            @Override
            public void onFailure(Call<RespuestaApiBooleana> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());

            }
        });


    }
    private void borrarParticipacion(String pencaId, String usuarioId) {
        ServicioApiListadoPencas interfaz = retro.create(ServicioApiListadoPencas.class);
        Call<RespuestaApiBooleana> respuestacall = interfaz.borrarSolicitarPenca(pencaId, usuarioId);
        respuestacall.enqueue(new Callback<RespuestaApiBooleana>() {
            @Override
            public void onResponse(Call<RespuestaApiBooleana> call, Response<RespuestaApiBooleana> response) {

                if (response.isSuccessful()) {
                    Log.e(ETIQUETA, "resp Borrsol part: " + response.body().getResultado());
                    RespuestaApiBooleana r = response.body();
                    String resultado = r.getResultado();
                    if (resultado.equals("true")) {
                        //Log.e(ETIQUETA, "resp srest: " + response.body().getResultado());
                        Toast.makeText(contexto , "borrado correcto", Toast.LENGTH_SHORT).show();
                        retornoBor =true;
                    } else {
                        Toast.makeText(contexto, "soliciud no exitosa", Toast.LENGTH_SHORT);
                    }
                } else {
                    Toast.makeText(contexto, "soliciud incorrecta", Toast.LENGTH_SHORT);
                }
            }


            @Override
            public void onFailure(Call<RespuestaApiBooleana> call, Throwable t) {
                Log.e(ETIQUETA, "en falla:" + t.getMessage());

            }
        });
    }
}