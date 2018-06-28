package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import modelos.Usuario;

public class MenuPrincipal extends AppCompatActivity {
    Button listaPartBtn;
    Button listaPencBtn;
    Button listaSolPartBtn;
    TextView hola;
    Bundle bundle;

    Usuario usuariologueado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        usuariologueado= ConfigSingletton.getInstance().getUsuarioLogueado();
        
        hola=findViewById(R.id.usrtxtmenutv);
        hola.setText("Bienvenido "+usuariologueado.getNombre());
        listaPartBtn=findViewById(R.id.btnListPart);
        listaPencBtn=findViewById(R.id.btnListPenc);
        listaSolPartBtn =findViewById(R.id.btnSolicitudes);
        listaPartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MenuPrincipal.this,ListadoParticipantes.class);
                startActivity(in);
            }
        });
        listaPencBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MenuPrincipal.this,ListadoPencas.class);
                startActivity(in);
            }
        });
        listaSolPartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MenuPrincipal.this,ListadoSolPencas.class);
                startActivity(in);
            }
        });

    }
}
