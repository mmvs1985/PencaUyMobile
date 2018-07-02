package com.grupo12.viera.pencauy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button log,conf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log=findViewById(R.id.btnLog);
        conf=findViewById(R.id.btnconf);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logueo=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(logueo);
            }
        });
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logueo=new Intent(MainActivity.this,ConfigurarActivity.class);
                startActivity(logueo);
            }
        });
    }
}
