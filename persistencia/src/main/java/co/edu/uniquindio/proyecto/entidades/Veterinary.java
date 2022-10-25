package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//Entidad hijo veterinario
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Veterinary extends Person implements Serializable
{
    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinary")
    private Integer id;

    //Atributo numero de la tarjeta profesional del veterinario
    @Column(nullable = false,length = 13)
    @Length(min = 5, max = 13, message = "La tarjeta profesional debe tener mínimo 5 caracteres y máximo 13")
    @NotBlank(message = "El campo está vacío, debe ingresar la tarjeta profesional")
    private String num_license;

    public Veterinary(@Length(min = 2, max = 80, message = "El nombre debe tener mínimo 2 caracteres y máximo 80") @NotBlank(message = "El campo está vacío, debe ingresar un nombre") String name, @Length(min = 5, max = 17, message = "El telefono debe tener mínimo 5 caracteres y máximo 17") @NotBlank(message = "El campo está vacío, debe ingresar un telefono") String phoneNumber, @Length(min = 5, max = 10, message = "La cedula debe tener mínimo 5 caracteres y máximo 10") @NotBlank(message = "El campo está vacío, debe ingresar la cedula") String identification, @Email(message = "Ingrese un correo válido") @NotBlank(message = "El campo correo no debe estar vacío") String email, String photoUrl, Integer sex, @NotBlank(message = "El campo está vacío, debe ingresar la contrasena") String password, LocalDateTime creationDate, String num_license) {
        super(name, phoneNumber, identification, email, photoUrl, sex, password, creationDate);
        this.num_license = num_license;
    }
//Relaciones

    //lista de chats
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinary",cascade = CascadeType.ALL)
    private List<Chat> chats;

    //lista consultas
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "veterinary",cascade = CascadeType.ALL )
    private List<Consultation> consultations;

    //lista atenciones
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "veterinary",cascade = CascadeType.ALL )
    private List<VeterinaryCare> veterinaryCares;
}
