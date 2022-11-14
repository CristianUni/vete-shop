package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Token;

import java.util.Calendar;

public interface TokenService {
    Token inserToken(Token token);

    Token findByPK(String email);

    Token setToken(String email, Calendar date, String token);
}
