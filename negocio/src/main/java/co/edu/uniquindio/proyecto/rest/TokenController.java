package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.TokenService;
import co.edu.uniquindio.proyecto.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Credential authenticationRequest) throws Exception {
        final User user = authenticate(authenticationRequest);
        Token token = new Token(user.getName());
        return ResponseEntity.ok(tokenService.inserToken(token));
    }

    private User authenticate(Credential request) throws Exception {
        User user = null;
        try {
            user = userService.getByNameAndPassword(request.getUserName(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("USER_DISABLED", e);
        }
        return user;
    }
}
