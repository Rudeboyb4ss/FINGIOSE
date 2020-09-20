package yo.pruebauno.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("filavirtual")
public class FilaVirtual {
    private Boolean estado;
    private String codigo;
    private List<Turno> clientesEspera; //numero de turno se saca del primer elemento de la lista
    private String horarioInicio;
    private String horarioTermino;
    private List<Receso> recesos;
    private int tiempoAtencion;  //cantidad de minutos
    private int turnoActual;

    public FilaVirtual(){
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Turno> getClientesEspera() {
        return clientesEspera;
    }

    public void setClientesEspera(List<Turno> clientesEspera) {
        this.clientesEspera = clientesEspera;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horario) {
        this.horarioInicio = horario;
    }

    public String getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public List<Receso> getRecesos() {
        return recesos;
    }

    public void setRecesos(List<Receso> recesos) {
        this.recesos = recesos;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }
}
