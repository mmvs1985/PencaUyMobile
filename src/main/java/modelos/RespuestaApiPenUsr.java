package modelos;


import android.util.Log;

public class RespuestaApiPenUsr {

    private Boolean resultado;
    private PencaUsuario pencaUsuario;

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public PencaUsuario getPencaUsuario() {
        return pencaUsuario;
    }

    public void setPencaUsuario(PencaUsuario pencaUsuario) {
        this.pencaUsuario = pencaUsuario;
        Log.e("Desde","Set pencausuario");
    }

}