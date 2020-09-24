package yo.pruebauno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yo.pruebauno.models.FilaVirtual;
import yo.pruebauno.models.Receso;
import yo.pruebauno.models.Turno;
import yo.pruebauno.repositories.FilaVirtualRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/filavirtual")
public class FilaVirtualService {

    @Autowired
    private FilaVirtualRepo filaRepo;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<FilaVirtual> getAll() {
        return this.filaRepo.findAll();
    }

    @RequestMapping(value = "/getbycodigo/{codigo}", method = RequestMethod.GET)
    @ResponseBody
    public FilaVirtual getByCodigo(@PathVariable(value = "codigo") String codigo) {
        return this.filaRepo.findFilaByCodigo(codigo);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody FilaVirtual fila) {
        filaRepo.save(fila);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public FilaVirtual edit(@RequestBody FilaVirtual fila) {
        FilaVirtual currentFila = filaRepo.findFilaByCodigo(fila.getCodigo());
        currentFila.setEstado(fila.getEstado());
        currentFila.setHorarioInicio(fila.getHorarioInicio());
        currentFila.setHorarioTermino(fila.getHorarioTermino());
        currentFila.setRecesos(fila.getRecesos());
        currentFila.setTiempoAtencion(fila.getTiempoAtencion());
        filaRepo.save(currentFila);
        return currentFila;
    }

    @RequestMapping(value = "/editarestado/{codigo}", method = RequestMethod.PUT)
    public FilaVirtual editarEstado2(@PathVariable String codigo) {
        System.out.println("me quiero matar");
        FilaVirtual currentFila = filaRepo.findFilaByCodigo(codigo);
        System.out.println("2");
        if(currentFila.getEstado() == true){
            System.out.println("3");
            currentFila.setEstado(false);
            currentFila.setPausada(true);
        }
        else{
            System.out.println("4");
            currentFila.setEstado(true);
            currentFila.setPausada(false); //cambia el pausado a false-> si se inicia la fila ya no esta pausada
        }
        System.out.println("2");
        filaRepo.save(currentFila);
        return currentFila;
    }

    @RequestMapping(value = "/editarpausada/{codigo}", method = RequestMethod.PUT)
    public FilaVirtual editarPausada(@PathVariable String codigo) {
        FilaVirtual currentFila = filaRepo.findFilaByCodigo(codigo);
        if(currentFila.getPausada() == true || currentFila.getPausada() == null){
            currentFila.setPausada(false);
        }
        else{
            currentFila.setPausada(true); //cambia el pausado a false-> si se inicia la fila ya no esta pausada
        }
        filaRepo.save(currentFila);
        return currentFila;
    }


    @RequestMapping(value = "/agregarturno", method = RequestMethod.POST)
    public void agregarTurno(@RequestBody FilaVirtual fila, Turno turno) {  //si no funciona agregar request
        fila.getClientesEspera().add(turno);
        filaRepo.save(fila);
    }

    @RequestMapping(value = "/pasarturno/{codigo}", method = RequestMethod.PUT)
    public FilaVirtual pasarTurno(@PathVariable String codigo) {
        FilaVirtual currentFila = filaRepo.findFilaByCodigo(codigo);
        currentFila.setTurnoActual(currentFila.getTurnoActual()+1);
        filaRepo.save(currentFila);
        return currentFila;
    }

    @RequestMapping(value = "/agregarreceso", method = RequestMethod.POST)
    public void agregarReceso(@RequestBody FilaVirtual fila, Receso receso) {  //si no funciona agregar request
        fila.getRecesos().add(receso);
        filaRepo.save(fila);
    }
}
