package modelos;

import java.io.Serializable;

/**
 * Created by HP Usuario on 11/6/2018.
 */

public class ItemPencas implements Serializable{
    private String id;
    private String nombre;
    private String precio;
    private String adminfront;
    private String torneo;
    private String estilo;
    private String fueSolicitada;

    public ItemPencas(String id, String nombre, String precio, String adminfront, String torneo, String estilo,String fueSolicitada) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.adminfront = adminfront;
        this.torneo = torneo;
        this.estilo = estilo;
        this.fueSolicitada = fueSolicitada;
    }

    public String getFueSolicitada() {
        return fueSolicitada;
    }

    public void setFueSolicitada(String fueSolicitada) {
        this.fueSolicitada = fueSolicitada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAdminfront() {
        return adminfront;
    }

    public void setAdminfront(String adminfront) {
        this.adminfront = adminfront;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
