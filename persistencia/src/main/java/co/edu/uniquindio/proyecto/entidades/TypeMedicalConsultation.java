package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TypeMedicalConsultation implements Serializable
{
    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_consultation")
    private Integer id;

    //Atributo tipo de cita
    @Column(nullable = false,length = 45)
    @Length(min = 1, max = 45, message = "El tipo debe tener mínimo 1 caracteres y máximo 500")
    @NotBlank(message = "El campo está vacío, ingresar un tipo de cita")
    private String description;

    //lista citas
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeMedicalConsultation",cascade = CascadeType.ALL)
    private List<Consultation> consultations;
}
