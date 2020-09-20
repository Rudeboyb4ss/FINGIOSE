package yo.pruebauno.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PruebaController {
    @GetMapping(value = "/prueba")
    public String myMethod() {
        System.out.println("Prueba");
        return "Pruebauno";
    }
}

