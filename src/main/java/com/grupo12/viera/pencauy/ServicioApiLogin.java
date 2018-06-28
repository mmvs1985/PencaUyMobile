package com.grupo12.viera.pencauy;

import modelos.RespuestaApiBooleana;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HP Usuario on 12/6/2018.
 */

public interface ServicioApiLogin {

    @POST("login/loginParticipante/{nick}/{pass}")
    Call<RespuestaApiBooleana> obtenerrespuesta(@Path("nick") String nick, @Path("pass") String pass);
}

