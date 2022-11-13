package co.edu.uniquindio.proyecto.entidades;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class LogicException extends WebApplicationException {
    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Response response) {
        super(message, response);
    }

    public LogicException(String message, Response.Status status) {
        super(message, status);
    }
}
