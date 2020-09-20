package yo.pruebauno.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("receso")
public class Receso {
    private String horaInicio;
    private String horaTermino;

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }
}
