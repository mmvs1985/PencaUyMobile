package com.grupo12.viera.pencauy;

import modelos.RespuestaApiBooleana;
import modelos.RespuestaApiPenUsr;
import modelos.RespuestaApiPencas;
import modelos.RespuestaApiTorneo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HP Usuario on 24/4/2018.
 */

public interface ServicioApiListadoPencas {
    @GET("listado/pencas")
    Call<RespuestaApiPencas> obtenerLista();

    @POST("solicitarPenca/{idPenca}/{idUsuario}")
    Call<RespuestaApiBooleana> solicitarParticipacion(@Path("idPenca") String idpenca, @Path("idUsuario") String idUsuario );

    @POST("borrarSolicitarPenca/{idPenca}/{idUsuario}")
    Call<RespuestaApiBooleana> borrarSolicitarPenca(@Path("idPenca") String idpenca, @Path("idUsuario") String idUsuario );

    @POST("listado/pencasSolicitadas/{idUsr}")
    Call<RespuestaApiPencas> obtenerListaPencasSolicitadas(@Path("idUsr") String idUsuario );

    @POST("torneo/getTorneoPorPenca/{idPenca}")
    Call<RespuestaApiTorneo>obtenerTorneoPorPenca(@Path("idPenca") String idPenca);

    @POST("pencausuario/existe_get/{idUsr}/{idPenca}")
    Call<RespuestaApiPenUsr>existe_getPencaUsuario(@Path("idPenca") String idPenca, @Path("idUsr") String idUsuario);
    /*
//int goleslocal, int golesvisita, int equipopasa, int partido, int pencausuario
    @POST("apuestas/realizar/")*/
}
