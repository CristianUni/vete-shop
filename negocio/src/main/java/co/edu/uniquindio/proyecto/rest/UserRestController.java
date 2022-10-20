package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.entidades.User;
import org.springframework.web.bind.annotation.*;
import co.edu.uniquindio.proyecto.repositorio.UserRepo;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class UserRestController {

    // standard constructors
    private final UserRepo userRepo;

    public UserRestController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepo.save(user);
    }
}
