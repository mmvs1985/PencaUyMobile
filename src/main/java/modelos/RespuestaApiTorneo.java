package modelos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RespuestaApiTorneo {

    private Integer id;
    private String nombre;
    private String tipo;
    private String comienzo;
    private List<Fase> fases = null;
    private List<Partido> partidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComienzo() {
        return comienzo;
    }

    public void setComienzo(String comienzo) {
        this.comienzo = comienzo;
    }

    public List<Fase> getFases() {
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases;
    }

    public List<Partido> getPartidos(){
        List<Partido> retorno=new ArrayList<Partido>();
        retorno.clear();
        if (fases!=null) {
            for (int i = 0; i < fases.size(); i++) {
                Fase f = fases.get(i);
                Log.e("Respuesta Api Torneo:","fase:"+f.getNombreFase());
                if (f.getGrupos() != null) {
                    List<Grupo> gs = f.getGrupos();
                    for (int e = 0; e < gs.size(); e++) {
                        Grupo g = gs.get(e);
                        Log.e("Respuesta Api Torneo:","grupo: "+g.getNombGrupo()+" part:"+g.getPartidos().size());
                        List<Partido> ps = g.getPartidos();

                        if(!ps.isEmpty()){
                            for(Partido p:ps) {
                                Log.e("Respuesta Api Partido:", "partido: " + p.getIdPartido());
                            }
                        }
                        retorno.addAll(ps);
                        }
                }
            }
        }
        Log.e("Respuesta Api Torneo:","ret : "+retorno.size());
        Collections.sort(retorno, new Comparator<Partido>() {
            @Override
            public int compare(Partido partido, Partido t1) {
                return partido.getIdPartido().compareTo(t1.getIdPartido());
            }
        });

        return retorno;
    }

}