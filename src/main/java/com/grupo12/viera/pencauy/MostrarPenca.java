package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import modelos.ItemPencas;

public class MostrarPenca extends AppCompatActivity {

    TextView pencaId,pencaNombre;
    ItemPencas item;
    Button participarbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_penca);
        Intent inte=getIntent();
        item=(ItemPencas)inte.getSerializableExtra("itemEnviado");
        pencaId=findViewById(R.id.nopencatv);
        pencaNombre=findViewById(R.id.nombrepencatv);
        pencaId.setText(item.getId());
        pencaNombre.setText(item.getNombre());
        participarbtn=findViewById(R.id.btnParticipar);
        participarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentorneo=new Intent(MostrarPenca.this, ListadoPartidoTorneo.class);
                intentorneo.putExtra("itemEnviado",item);
                startActivity(intentorneo);
            }
        });


    }
}
