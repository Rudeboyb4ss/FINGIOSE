package yo.pruebauno.services;

import yo.pruebauno.models.User;
import yo.pruebauno.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll() {
        return this.userRepo.findAll();
    }

    @RequestMapping(value = "/getbyrut/{rut}", method = RequestMethod.GET)
    @ResponseBody
    public User getByRut(@PathVariable(value = "rut") String rut) {
        return this.userRepo.findUserByRut(rut);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public User edit(@RequestBody User user) {
        User currentUser = userRepo.findUserByRut(user.getRut());
        currentUser.setNombre(user.getNombre());
        currentUser.setCorreo(user.getCorreo());
        userRepo.save(currentUser);
        return currentUser;
    }
}
