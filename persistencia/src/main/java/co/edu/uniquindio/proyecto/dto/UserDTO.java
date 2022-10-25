package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String phoneNumber;
    private String identification;
    private String email;
    private Integer sex;
    private String password;
}
