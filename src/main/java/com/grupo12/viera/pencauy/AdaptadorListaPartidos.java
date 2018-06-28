package com.grupo12.viera.pencauy;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import modelos.Partido;

/**
 * Created by HP Usuario on 26/6/2018.
 */

public class AdaptadorListaPartidos extends RecyclerView.Adapter<AdaptadorListaPartidos.ViewHolder> {

    public List<Partido> listaPartidos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView equipoLocal,equipoVisitante,golesLoc,golesVisitante,noPartido,fechaPartido;

        public ViewHolder(View itemView) {
            super(itemView);
            equipoLocal=(TextView)itemView.findViewById(R.id.equipoLoctv);
            equipoVisitante=(TextView)itemView.findViewById(R.id.equipovistv);
            golesLoc=(TextView)itemView.findViewById(R.id.golesLoctv);
            golesVisitante=(TextView)itemView.findViewById(R.id.golesVistv);
            noPartido=(TextView)itemView.findViewById(R.id.noPartidotv);
            fechaPartido=(TextView)itemView.findViewById(R.id.fechaPartidotv);
        }

    }

    public AdaptadorListaPartidos(List<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    @Override
    public AdaptadorListaPartidos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partido,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdaptadorListaPartidos.ViewHolder holder, int position) {
        Log.e("List Part adp","pos: "+position+" de "+listaPartidos.get(position).getIdPartido()
        );
        holder.equipoLocal.setText(listaPartidos.get(position).getPartidoEquipoLocal());
        holder.equipoVisitante.setText(listaPartidos.get(position).getPartidoEquipoVisita());
        holder.golesLoc.setText(listaPartidos.get(position).getPartidoGolesEquipoLocal());
        holder.golesVisitante.setText(listaPartidos.get(position).getPartidoGolesEquipoVisita());
        //holder.noPartido.setText(listaPartidos.get(position).getIdPartido());
        holder.noPartido.setText(listaPartidos.get(position).getIdPartido().toString());
        holder.fechaPartido.setText(listaPartidos.get(position).getPartidoFecha());
    }

    @Override
    public int getItemCount() {
        return listaPartidos.size();
    }


}
