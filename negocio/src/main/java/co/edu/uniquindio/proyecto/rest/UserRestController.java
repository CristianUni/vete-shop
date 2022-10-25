package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.UserDTO;
import co.edu.uniquindio.proyecto.entidades.Person;
import co.edu.uniquindio.proyecto.entidades.User;
import co.edu.uniquindio.proyecto.entidades.Veterinary;
import co.edu.uniquindio.proyecto.segurity.Cookies;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.UserService;
import co.edu.uniquindio.proyecto.servicios.VeterinaryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uniquindio.proyecto.repositorio.UserRepo;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private VeterinaryService veterinaryService;

    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody Person user) throws Exception {
        try {
            User u = userService.createUser(new User(user.getName(), user.getPhoneNumber(), user.getIdentification(), user.getEmail(),"",user.getSex(), Hash.factory().toSha1(user.getPassword()), LocalDateTime.now()));
            ResponseCookie springCookie = Cookies.factory().setCookieUser(Hash.factory().toSha1(u.getId().toString()));
            return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String email,@RequestParam String password){
        try {
            User user = userService.findByEmail(email);
            if(user != null){
                if(user.getPassword().equals(Hash.factory().toSha1(password))) {
                    ResponseCookie springCookie = Cookies.factory().setCookieUser(Hash.factory().toSha1(user.getId().toString()));
                    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
                }
            }
            Veterinary veterinary = veterinaryService.findByEmail(email);
            if(veterinary != null){
                if(veterinary.getPassword().equals(Hash.factory().toSha1(password))) {
                    ResponseCookie springCookie = Cookies.factory().setCookieVeterinary(Hash.factory().toSha1(veterinary.getId().toString()));
                    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header("message","Correo y contraseña incorrectos").build();
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@CookieValue(name = "veterinary-id")String veterinaryId) {
        try {
            ResponseCookie deleteCookie;
            if(veterinaryId!= null && !veterinaryId.isEmpty()){
                deleteCookie= Cookies.factory().deleteCookieVeterinary();
            }else{
                deleteCookie = Cookies.factory().deleteCookieUser();
            }
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, deleteCookie.toString()).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}





