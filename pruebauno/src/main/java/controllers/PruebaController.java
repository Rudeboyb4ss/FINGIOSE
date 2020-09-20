package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
class PruebaController {
    @GetMapping("/prueba")
    public String myMethod() {
        System.out.println("Prueba");
        return "Pruebauno";
    }
}

