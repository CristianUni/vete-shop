package co.edu.uniquindio.proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

public class ResponseMessage implements Serializable {
    @JsonbProperty("mensaje")
    private final String responsemessage;

    private ResponseMessage(String responsemessage) {
        this.responsemessage = responsemessage;
    }

    public static ResponseMessage of(String responsemessage) {
        return new ResponseMessage(responsemessage);
    }
}
