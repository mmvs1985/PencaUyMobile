package com.grupo12.viera.pencauy;

import modelos.RespuestaApi;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP Usuario on 24/4/2018.
 */

public interface ServicioApiListadoParticipantes {
    @GET("listado/participantes")
    Call<RespuestaApi> obtenerLista();
}
