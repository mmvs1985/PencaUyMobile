package com.grupo12.viera.pencauy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import modelos.ItemParticipante;

/**
 * Created by HP Usuario on 11/6/2018.
 */

public class AdaptadorParticipantes extends BaseAdapter {
    private ArrayList<ItemParticipante> listItems;
    private Context contexto;

    public AdaptadorParticipantes( Context contexto,ArrayList<ItemParticipante> listItems) {
        this.listItems = listItems;
        this.contexto = contexto;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemParticipante item=(ItemParticipante) getItem(i);
        view= LayoutInflater.from(contexto).inflate(R.layout.item_participante,null);
        TextView tvnick=(TextView) view.findViewById(R.id.nicknametv);
        TextView tvptos=(TextView) view.findViewById(R.id.ptostv);
        tvnick.setText(item.getNickname());
        tvptos.setText(item.getPuntos());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
