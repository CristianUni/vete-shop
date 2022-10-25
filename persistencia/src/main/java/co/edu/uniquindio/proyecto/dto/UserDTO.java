package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable {

    public UserDTO(String name, String phoneNumber, String identification, String email, Integer sex, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.identification = identification;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    private String name;
    private String phoneNumber;
    private String identification;
    private String email;
    private Integer sex;
    private String password;
}
