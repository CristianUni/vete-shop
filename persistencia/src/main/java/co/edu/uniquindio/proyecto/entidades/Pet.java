package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pet implements Serializable
{
    //Atributo id mascota
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet")
    private Integer id;

    //Atributo nombre mascota
    @Column(nullable = false,length = 80)
    @Length(min = 2, max = 80, message = "El nombre debe tener mínimo 2 caracteres y máximo 80")
    @NotBlank(message = "El campo está vacío, debe ingresar un nombre")
    private  String name;

    //Atributo nacimiento mascota
    @Column(nullable = false)
    private LocalDate birthdate;

    //condicion de la mascota (hospitalizada , guarderia, )
    @Column(name = "status", nullable = false)
    private Integer status;

    //Sexo de la mascota (macho, hembra, no especificado)
    @Column(name = "sex", nullable = false)
    private Integer sex;

    //Relaciones

    //Atributo id del usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    //Atributo id de la mascota
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_pet")
    private TypePet typePet;

    //lista de atenciones
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet",cascade = CascadeType.ALL)
    private List<VeterinaryCare> veterinaryCares;

    //lista de citas
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet",cascade = CascadeType.ALL)
    private List<Consultation> consultations;
}
