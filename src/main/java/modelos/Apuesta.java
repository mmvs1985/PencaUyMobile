package modelos;


//import java.io.Serializable;

public class Apuesta {//implements Serializable {

    private Integer idApuesta;
    private Integer partidoId;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisita;
    private String nombre;
    private Integer puntos;
    private final static long serialVersionUID =-1382081339894538758L;

    public Integer getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(Integer idApuesta) {
        this.idApuesta = idApuesta;
    }

    public Integer getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Integer partidoId) {
        this.partidoId = partidoId;
    }

    public Integer getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(Integer golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public Integer getGolesEquipoVisita() {
        return golesEquipoVisita;
    }

    public void setGolesEquipoVisita(Integer golesEquipoVisita) {
        this.golesEquipoVisita = golesEquipoVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

}