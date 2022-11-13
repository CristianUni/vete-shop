package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Token;
import co.edu.uniquindio.proyecto.repositorio.TokenRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenServiceImp implements TokenService{

    private final TokenRepo tokenRepo;

    public TokenServiceImp(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Token inserToken(Token token) throws Exception {

        Optional<Token> buscado = tokenRepo.findById(token.getId());

        if (buscado.isPresent()) throw new Exception("El usuario " + token.getUserName() + " tiene una sesion iniciada.");

        return tokenRepo.save(token);
    }
}
