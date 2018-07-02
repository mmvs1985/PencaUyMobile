
package modelos;


import java.io.Serializable;

public class Partido implements Serializable {

    private Integer idPartido;
    private String partidoEquipoGanador;
    private String partidoEquipoLocal;
    private String partidoEquipoVisita;
    private String partidoEstado;
    private String partidoFecha;
    private String partidoGolesEquipoLocal;
    private String partidoGolesEquipoVisita;

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public String getPartidoEquipoGanador() {
        return partidoEquipoGanador;
    }

    public void setPartidoEquipoGanador(String partidoEquipoGanador) {
        this.partidoEquipoGanador = partidoEquipoGanador;
    }

    public String getPartidoEquipoLocal() {
        return partidoEquipoLocal;
    }

    public void setPartidoEquipoLocal(String partidoEquipoLocal) {
        this.partidoEquipoLocal = partidoEquipoLocal;
    }

    public String getPartidoEquipoVisita() {
        return partidoEquipoVisita;
    }

    public void setPartidoEquipoVisita(String partidoEquipoVisita) {
        this.partidoEquipoVisita = partidoEquipoVisita;
    }

    public String getPartidoEstado() {
        return partidoEstado;
    }

    public void setPartidoEstado(String partidoEstado) {
        this.partidoEstado = partidoEstado;
    }

    public String getPartidoFecha() {
        return partidoFecha;
    }

    public void setPartidoFecha(String partidoFecha) {
        this.partidoFecha = partidoFecha;
    }

    public String getPartidoGolesEquipoLocal() {
        return partidoGolesEquipoLocal;
    }

    public void setPartidoGolesEquipoLocal(String partidoGolesEquipoLocal) {
        this.partidoGolesEquipoLocal = partidoGolesEquipoLocal;
    }

    public String getPartidoGolesEquipoVisita() {
        return partidoGolesEquipoVisita;
    }

    public void setPartidoGolesEquipoVisita(String partidoGolesEquipoVisita) {
        this.partidoGolesEquipoVisita = partidoGolesEquipoVisita;
    }

}