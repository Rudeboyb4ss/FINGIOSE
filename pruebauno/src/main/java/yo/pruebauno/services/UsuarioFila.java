package yo.pruebauno.services;

import yo.pruebauno.models.FilaVirtual;
import yo.pruebauno.models.User;

public class UsuarioFila {
    private User usuario;
    private String codigoFila;

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getCodigoFila() {
        return codigoFila;
    }

    public void setCodigoFila(String codigoFila) {
        this.codigoFila = codigoFila;
    }
}