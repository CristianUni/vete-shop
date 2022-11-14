package co.edu.uniquindio.proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;

public class Credential {
    @NotBlank(message = "Correo obligatorio.")
    @JsonbProperty("email")
    private String email;
    @NotBlank(message = "La clave es obligatoria.")
    @JsonbProperty("password")
    private String password;

    public Credential() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Credential(String userName, String password) {
        this.email = userName;
        this.password = password;
    }
}