package modelos;

import java.util.List;

public class Grupo {

    private Integer idGrupo;
    private String nombGrupo;
    private List<Partido> partidos = null;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombGrupo() {
        return nombGrupo;
    }

    public void setNombGrupo(String nombGrupo) {
        this.nombGrupo = nombGrupo;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

}