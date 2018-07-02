package modelos;

import java.io.Serializable;
import java.util.List;

public class PencaUsuario implements Serializable {

    private Integer id;
    private Integer puntos;
    private Integer idpenca;
    private Integer idusuario;
    private final static long serialVersionUID =2871209642999654713L;
    private List<Apuesta> apuestas = null;

    public PencaUsuario(Integer id, Integer puntos, Integer idpenca, Integer idusuario, List<Apuesta> apuestas) {
        this.id = id;
        this.puntos = puntos;
        this.idpenca = idpenca;
        this.idusuario = idusuario;
        this.apuestas = apuestas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getIdpenca() {
        return idpenca;
    }

    public void setIdpenca(Integer idpenca) {
        this.idpenca = idpenca;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

}