package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

//Padre persona
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@ToString
public class Person implements Serializable {


    //Atributo nombre de la persona
    @Column(nullable = false,length = 80)
    @Length(min = 2, max = 80, message = "El nombre debe tener mínimo 2 caracteres y máximo 80")
    @NotBlank(message = "El campo está vacío, debe ingresar un nombre")
    private String name;

    //Atributo telefono de la persona
    @Column(nullable = false,length = 17)
    @Length(min = 5, max = 17, message = "El telefono debe tener mínimo 5 caracteres y máximo 17")
    @NotBlank(message = "El campo está vacío, debe ingresar un telefono")
    private String phoneNumber;

    //Atributo cedula de la persona
    @Column(nullable = false,length = 10)
    @Length(min = 5, max = 10, message = "La cedula debe tener mínimo 5 caracteres y máximo 10")
    @NotBlank(message = "El campo está vacío, debe ingresar la cedula")
    private String identification;

    //Atributo correo de la persona
    @Column(nullable = false, unique = true,length = 100)
    @Email(message = "Ingrese un correo válido")
    @NotBlank(message = "El campo correo no debe estar vacío")
    private String email;

    //Atributo ruta de la foto de perfil
    @Column(nullable = true,length = 150)
    private String photo_url;

    @Column(name = "sex", nullable = false)
    private Integer sex;

    //Atributo contrasena de la persona
    @Column(nullable = false,length = 40)
    @NotBlank(message = "El campo está vacío, debe ingresar la contrasena")
    private String password;

    //Atributo que sirve para guardar la hora y fecha de cuando se crea un usuario o admin
    @Column(name = "date_creation",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationDate;

}
