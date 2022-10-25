package co.edu.uniquindio.proyecto.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VeterinaryDTO {

    private String name;
    private String phoneNumber;
    private String identification;
    private String email;
    private Integer sex;
    private String password;
    private String num_license;

}
