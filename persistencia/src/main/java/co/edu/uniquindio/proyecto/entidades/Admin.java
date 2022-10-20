package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Admin implements Serializable {

    //llave primaria examen
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer id;

    //Atributo correo del admin
    @Column(nullable = false, unique = true,length = 100)
    @Email(message = "Ingrese un correo válido")
    @NotBlank(message = "El campo correo no debe estar vacío")
    private String email;

    //Atributo contrasena del admin
    @Column(nullable = false,length = 40)
    @NotBlank(message = "El campo está vacío, debe ingresar la contrasena")
    private String password;
}
