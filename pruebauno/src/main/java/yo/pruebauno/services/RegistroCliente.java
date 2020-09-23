package yo.pruebauno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yo.pruebauno.models.FilaVirtual;
import yo.pruebauno.models.Turno;
import yo.pruebauno.repositories.FilaVirtualRepo;
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
    @Autowired
    private FilaVirtualRepo filaRepo;


    // Entrega el total de todos los turnos de todas las filas (está mal) --------*
    @RequestMapping(value = "/calcularId", method = RequestMethod.GET)
    public int calcularId(FilaVirtual fila) {
        int nuevoId = fila.getClientesEspera().size() + 1;
        //int nuevoId = this.turnoRepo.findAll().size() + 1;
        return nuevoId;
    }

    @RequestMapping(value = "/asignarturno", method = RequestMethod.POST)
    public void agregarTurno(@RequestBody UsuarioFila user_fila) {  //si no funciona agregar request
        String codigoFila = user_fila.getCodigoFila();
        User usuario = user_fila.getUsuario();
        FilaVirtual fila = filaRepo.findFilaByCodigo(codigoFila);
        int id = calcularId(fila);
        Turno turnoNuevo = new Turno();
        turnoNuevo.setTiempoEspera(1);
        turnoNuevo.setCliente(usuario);
        turnoNuevo.setId(id);
        fila.getClientesEspera().add(turnoNuevo);
        registroRepo.save(fila);
    }
}
