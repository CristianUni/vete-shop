package co.edu.uniquindio.proyecto.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class VeterinaryDTO implements Serializable {

    public VeterinaryDTO(String name, String phoneNumber, String identification, String email, Integer sex, String password, String num_license) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.identification = identification;
        this.email = email;
        this.sex = sex;
        this.password = password;
        this.num_license = num_license;
    }

    private String name;
    private String phoneNumber;
    private String identification;
    private String email;
    private Integer sex;
    private String password;
    private String num_license;

}
