package yo.pruebauno.models;

public class Turno {
    private int id;
    private int tiempoEspera; //tiempo en minutos
    private User cliente; //Quizas cambiar despues por usuarioCliente

    public Turno(int id, int tiempoEspera, User cliente) {
        this.id = id;
        this.tiempoEspera = tiempoEspera;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }
}