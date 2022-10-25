package co.edu.uniquindio.proyecto.rest;


import co.edu.uniquindio.proyecto.dto.VeterinaryDTO;
import co.edu.uniquindio.proyecto.entidades.Veterinary;
import co.edu.uniquindio.proyecto.segurity.Cookies;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class VeterinaryRestController {

    @Autowired
    private VeterinaryService veterinaryService;


    @PostMapping("/veterinary")
    public ResponseEntity<String> saveVeterinary(@RequestBody VeterinaryDTO veterinary) throws  Exception{
        try {
            Veterinary v=veterinaryService.createVeterinary(new Veterinary(veterinary.getName(),veterinary.getPhoneNumber(),veterinary.getIdentification(),veterinary.getEmail(),"",veterinary.getSex(), Hash.factory().toSha1(veterinary.getPassword()), LocalDateTime.now(),veterinary.getNum_license()));
            ResponseCookie springCookie = Cookies.factory().setCookieVeterinary(Hash.factory().toSha1(v.getId().toString()));
            return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
