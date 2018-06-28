package modelos;

/**
 * Created by HP Usuario on 11/6/2018.
 */

public class ItemParticipante {
    private String nombre;
    private String apellido;
    private  String email;
    private String nickname;
    private  String puntos;

    public ItemParticipante(String nombre, String apellido, String email, String nickname, String puntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nickname = nickname;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
}
