package com.grupo12.viera.pencauy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import modelos.ItemPencas;
import modelos.Partido;

/**
 * Created by HP Usuario on 26/6/2018.
 */

public class AdaptadorListaPartidoscApuesta extends RecyclerView.Adapter<AdaptadorListaPartidoscApuesta.ViewHolder> {

    public List<Partido> listaPartidos;
    Context contexto;
    ItemPencas pu;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView equipoLocal, equipoVisitante, golesLoc, golesVisitante, noPartido, fechaPartido;
        EditText golesLocET, golesvisET;
        Button btnEnv;
        //RadioGroup rg;
        //RadioButton loc,vis;
        


        public ViewHolder(View itemView) {
            super(itemView);
            equipoLocal = (TextView) itemView.findViewById(R.id.equipoLoctv);
            equipoVisitante = (TextView) itemView.findViewById(R.id.equipovistv);
            golesLoc = (TextView) itemView.findViewById(R.id.golesLoctv);
            golesVisitante = (TextView) itemView.findViewById(R.id.golesVistv);
            noPartido = (TextView) itemView.findViewById(R.id.noPartidotv);
            fechaPartido = (TextView) itemView.findViewById(R.id.fechaPartidotv);
           /* golesLocET = (EditText) itemView.findViewById(R.id.golesLocET);
            golesvisET = (EditText) itemView.findViewById(R.id.golesvisET);*/
            btnEnv = (Button) itemView.findViewById(R.id.btnenv);
            /*rg=(RadioGroup)itemView.findViewById(R.id.radioGroup);
            loc=(RadioButton)itemView.findViewById(R.id.locRb);
            vis=(RadioButton)itemView.findViewById(R.id.visitaRB);*/
            //rg.setVisibility(View.INVISIBLE);
           /* golesLocET.setVisibility(View.INVISIBLE);
            golesvisET.setVisibility(View.INVISIBLE);*/
            btnEnv.setVisibility(View.INVISIBLE);
            

        }

    }

    public AdaptadorListaPartidoscApuesta(List<Partido> listaPartidos,Context contexto,ItemPencas pu) {
        this.listaPartidos = listaPartidos;
        this.contexto=contexto;
        this.pu=pu;
    }

    @Override
    public AdaptadorListaPartidoscApuesta.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partido, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final AdaptadorListaPartidoscApuesta.ViewHolder holder, int position) {
        Log.e("List Part adp", "pos: " + position + " de " + listaPartidos.get(position).getIdPartido()
        );
        final Partido partidoElegido=listaPartidos.get(position);
        holder.equipoLocal.setText(listaPartidos.get(position).getPartidoEquipoLocal());
        holder.equipoVisitante.setText(listaPartidos.get(position).getPartidoEquipoVisita());
        holder.golesLoc.setText(listaPartidos.get(position).getPartidoGolesEquipoLocal());
        holder.golesVisitante.setText(listaPartidos.get(position).getPartidoGolesEquipoVisita());
        holder.noPartido.setText(listaPartidos.get(position).getIdPartido().toString());
        holder.fechaPartido.setText(listaPartidos.get(position).getPartidoFecha());
        if (listaPartidos.get(position).getPartidoEstado().equals("NOJUGADO")) {
            holder.btnEnv.setVisibility(View.VISIBLE);
            holder.golesLoc.setVisibility(View.INVISIBLE);
            holder.golesVisitante.setVisibility(View.INVISIBLE);
            holder.btnEnv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(contexto,MostrarPartido.class);
                    in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    in.putExtra("itemEnviado",partidoElegido);
                    in.putExtra("penca",pu);
                    contexto.startActivity(in);
                    

                }
            });

        } else {
            holder.golesLoc.setText(listaPartidos.get(position).getPartidoGolesEquipoLocal());
            holder.golesVisitante.setText(listaPartidos.get(position).getPartidoGolesEquipoVisita());

        }
    }

    @Override
    public int getItemCount() {
        return listaPartidos.size();
    }

    /*private void solicitarParticipacion(int golesLocal,int golesVisita,int idequipopasa,int idpartido,int idpencausuario) {

        final String ETIQUETA = "Resp API apuesta";
        Retrofit retro=ConfigSingletton.getInstance().getRetro();
        ServicioApiListadoPencas interfaz = retro.create(ServicioApiListadoPencas.class);
        Call<RespuestaApiBooleana> respuestacall = interfaz.realizarApuesta( golesLocal,golesVisita,idequipopasa,idpartido,idpencausuario);
        respuestacall.enqueue(new Callback<RespuestaApiBooleana>() {
            @Override
            public void onResponse(Call<RespuestaApiBooleana> call, Response<RespuestaApiBooleana> response) {

                if (response.isSuccessful()) {
                    Log.e(ETIQUETA, "resp solicita part: " + response.body().getResultado());
                    RespuestaApiBooleana r = response.body();
                    String resultado = r.getResultado();
                    if (resultado.equals("true")) {
                        Log.e(ETIQUETA, "resp srest: " + response.body().getResultado());
                    } else {
                        Log.e(ETIQUETA, "resp no: " + response.body().getResultado());
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


    }*/
}