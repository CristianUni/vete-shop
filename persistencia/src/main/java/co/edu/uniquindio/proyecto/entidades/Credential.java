package co.edu.uniquindio.proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;

public class Credential {
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @JsonbProperty("userName")
    private String userName;
    @NotBlank(message = "La clave es obligatoria.")
    @JsonbProperty("password")
    private String password;

    public Credential() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Credential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
