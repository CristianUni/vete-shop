package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.AdminService;
import co.edu.uniquindio.proyecto.servicios.TokenService;
import co.edu.uniquindio.proyecto.servicios.UserService;
import co.edu.uniquindio.proyecto.servicios.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private VeterinaryService veterinaryService;

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Credential authenticationRequest) throws Exception {
        final User user = authenticate(authenticationRequest);
        Token token = new Token(user.getEmail());
        if(tokenService.findByPK(authenticationRequest.getEmail()) == null)
        {
            return ResponseEntity.ok(tokenService.inserToken(token));
        }
        else {
            return ResponseEntity.ok(tokenService.setToken(token.getEmail(),token.getExpirationDate(),token.getToken()));
        }
    }

    @PostMapping(value = "/login-admin")
    public ResponseEntity<?> createAuthenticationTokenAdmin(@RequestBody Credential authenticationRequest) throws Exception {
        final Admin admin = authenticateAdmin(authenticationRequest);
        Token token = new Token(admin.getEmail());
        if(tokenService.findByPK(authenticationRequest.getEmail()) == null)
        {
            return ResponseEntity.ok(tokenService.inserToken(token));
        }
        else {
            return ResponseEntity.ok(tokenService.setToken(token.getEmail(),token.getExpirationDate(),token.getToken()));
        }
    }

    @PostMapping(value = "/login-vet")
    public ResponseEntity<?> createAuthenticationTokenVet(@RequestBody Credential authenticationRequest) throws Exception {
        final Veterinary vet = authenticateVet(authenticationRequest);
        Token token = new Token(vet.getEmail());
        if(tokenService.findByPK(authenticationRequest.getEmail()) == null)
        {
            return ResponseEntity.ok(tokenService.inserToken(token));
        }
        else {
            return ResponseEntity.ok(tokenService.setToken(token.getEmail(),token.getExpirationDate(),token.getToken()));
        }
    }

    private User authenticate(Credential request) throws Exception {
        User user = null;
        try {
            user = userService.getByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("USER_NOT_FOUND", e);
        }
        return user;
    }

    private Admin authenticateAdmin(Credential request) throws Exception {
        Admin admin = null;
        try {
            admin = adminService.findByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("ADMIN_NOT_FOUND", e);
        }
        return admin;
    }

    private Veterinary authenticateVet(Credential request) throws Exception {
        Veterinary vet = null;
        try {
            vet = veterinaryService.findByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("VET_NOT_FOUND", e);
        }
        return vet;
    }
}
