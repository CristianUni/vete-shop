package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Token;
import co.edu.uniquindio.proyecto.repositorio.TokenRepo;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class TokenServiceImp implements TokenService{

    private final TokenRepo tokenRepo;

    public TokenServiceImp(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Token inserToken(Token token) {
        return tokenRepo.save(token);
    }

    @Override
    public Token findByPK(String email) {

        Optional<Token> buscado = tokenRepo.findByPK(email);
        if(buscado.isEmpty())
        {
            return null;
        }
        return buscado.get();
    }

    @Override
    public Token setToken(String email, Calendar date, String token) {
        tokenRepo.setToken(email, date, token);
        Optional<Token> busc = tokenRepo.findByPK(email);
        if(busc.isEmpty())
        {
            return null;
        }
        return busc.get();
    }


}
