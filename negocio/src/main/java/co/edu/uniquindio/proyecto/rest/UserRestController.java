package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.entidades.Person;
import co.edu.uniquindio.proyecto.entidades.User;
import co.edu.uniquindio.proyecto.servicios.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uniquindio.proyecto.repositorio.UserRepo;

import java.util.List;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody Person p) throws Exception {
        try {
            User u= userService.createUser(new User(p.getName(), p.getPhoneNumber(), p.getIdentification(), p.getEmail(),p.getPhoto_url(),p.getSex(),p.getPassword(),p.getCreationDate()));
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}





