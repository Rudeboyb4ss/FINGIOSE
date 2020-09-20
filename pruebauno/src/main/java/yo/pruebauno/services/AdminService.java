package yo.pruebauno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yo.pruebauno.models.Admin;
import yo.pruebauno.repositories.AdminRepo;


import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin")

public class AdminService {
        @Autowired
        private AdminRepo adminRepo;

        @RequestMapping(value = "/getall", method = RequestMethod.GET)
        @ResponseBody
        public List<Admin> getAll() {
            System.out.println("Holaaaaa");
            return this.adminRepo.findAll();
        }

    @RequestMapping(value = "/getbyrut/{rut}", method = RequestMethod.GET)
    @ResponseBody
    public Admin getByRut(@PathVariable(value = "rut") String rut) {
        return this.adminRepo.findAdminByRut(rut);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Admin admin) {

            adminRepo.save(admin);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Admin edit(@RequestBody Admin admin) {

        Admin currentAdmin = adminRepo.findAdminByRut(admin.getRut());
        currentAdmin.setNombre(admin.getNombre());
        currentAdmin.setCorreo(admin.getCorreo());
        adminRepo.save(currentAdmin);
        return currentAdmin;
    }
}
