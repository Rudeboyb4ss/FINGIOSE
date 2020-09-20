package yo.pruebauno.services;

import yo.pruebauno.models.Turno;
import yo.pruebauno.repositories.TurnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/turno")
public class TurnoService {
    @Autowired
    private TurnoRepo turnoRepo;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<Turno> getAll() {
        return this.turnoRepo.findAll();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Turno getById(@PathVariable(value = "id") int id) {
        return this.turnoRepo.findTurnoById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Turno turno) {
        turnoRepo.save(turno);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Turno edit(@RequestBody Turno turno) {
        Turno currentTurno = turnoRepo.findTurnoById(turno.getId());
        currentTurno.setTiempoEspera(turno.getTiempoEspera());

        turnoRepo.save(currentTurno);
        return currentTurno;
    }

    @RequestMapping(value = "/calcularId", method = RequestMethod.GET)
    public int calcularId() {
        int nuevoId = this.turnoRepo.findAll().size() + 1;
        return nuevoId;
    }
}
