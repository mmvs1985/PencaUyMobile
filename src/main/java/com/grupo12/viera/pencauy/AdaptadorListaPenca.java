package com.grupo12.viera.pencauy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import modelos.ItemPencas;
import retrofit2.Retrofit;


public class AdaptadorListaPenca extends BaseAdapter{
    private static final String ETIQUETA = "RESPlist pencas adp";
    private ArrayList<ItemPencas> listItems;
    private Context contexto;
    private Retrofit retro;
    private String idUsuarioLog;

    public AdaptadorListaPenca( Context contexto,ArrayList<ItemPencas> listItems, Retrofit retro, String idUsuarioLog) {
        this.listItems = listItems;
        this.contexto = contexto;
        this.retro = retro;
        this.idUsuarioLog = idUsuarioLog;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Log.e(ETIQUETA,"entro al adp");
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
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(contexto,MostrarPenca.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("itemEnviado", item);
                contexto.startActivity(in);
            }
        });
        return view;
    }
}
