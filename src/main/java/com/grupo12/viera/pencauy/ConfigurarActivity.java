package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigurarActivity extends AppCompatActivity {
    EditText ip1,ip2,ip3,ip4;
    Button btnconf;
    ConfigSingletton cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        ip1=(EditText)findViewById(R.id.ip1ET);
        ip2=(EditText)findViewById(R.id.ip2ET);
        ip3=(EditText)findViewById(R.id.ip3ET);
        ip4=(EditText)findViewById(R.id.ip4ET);
        btnconf=findViewById(R.id.btnConfigurar);
        cs=ConfigSingletton.getInstance();
        btnconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cs.setIp(ip1.getText().toString()+"."+ip2.getText().toString()+"."+ip3.getText().toString()+"."+ip4.getText().toString());
                Toast.makeText(getApplicationContext(), "ip: "+ip1.getText().toString()+"."+ip2.getText().toString()+"."+ip3.getText().toString()+"."+ip4.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent logueo=new Intent(ConfigurarActivity.this,MainActivity.class);
                startActivity(logueo);
            }
        });


    }
}
