package yo.pruebauno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yo.pruebauno.models.FilaVirtual;
import yo.pruebauno.models.Turno;
import yo.pruebauno.repositories.TurnoRepo;
import yo.pruebauno.models.User;
import yo.pruebauno.repositories.RegistroClienteRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/registrocliente")
public class RegistroCliente {
    @Autowired
    private RegistroClienteRepo registroRepo;
    private TurnoRepo turnoRepo;

    @RequestMapping(value = "/calcularId", method = RequestMethod.GET)
    public int calcularId() {
        int nuevoId = this.turnoRepo.findAll().size() + 1;
        return nuevoId;
    }

    @RequestMapping(value = "/asignarTurno", method = RequestMethod.POST)
    public void agregarTurno(@RequestBody User usuario, FilaVirtual fila) {  //si no funciona agregar request
        int id = calcularId();
        int tiempoEspera = 1;
        //Turno turnoNuevo = new Turno(id, tiempoEspera, usuario);
        Turno turnoNuevo = new Turno();
        turnoNuevo.setTiempoEspera(1);
        turnoNuevo.setCliente(usuario);
        turnoNuevo.setId(id);
        fila.getClientesEspera().add(turnoNuevo);
        registroRepo.save(fila);
    }
}
