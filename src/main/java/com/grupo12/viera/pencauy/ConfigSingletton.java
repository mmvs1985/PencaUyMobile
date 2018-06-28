package com.grupo12.viera.pencauy;

import android.util.Log;

import modelos.Usuario;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP Usuario on 15/6/2018.
 */

public class ConfigSingletton {
    private static final ConfigSingletton ourInstance = new ConfigSingletton();
    private static final String urlbase="http://192.168.1.8:8180/PencaUyLocal-Backoffice-servicios/rest/api/";
    private static Usuario usuarioLogueado;
    private static Retrofit retro=null;

    public synchronized static ConfigSingletton getInstance() {
        return ourInstance;
    }

    public Retrofit getRetro() {
        if (ConfigSingletton.retro == null) {
            ConfigSingletton.retro = new Retrofit.Builder()
                                            .baseUrl(ConfigSingletton.urlbase)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();
            Log.e("Singletton","retrofit creado");
            return ConfigSingletton.retro;
        }
        else {
            Log.e("Singletton","retrofit ya creado");
            return ConfigSingletton.retro;
        }
    }


    public String getUrlbase() {
        return urlbase;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    private ConfigSingletton() {
    }
}
