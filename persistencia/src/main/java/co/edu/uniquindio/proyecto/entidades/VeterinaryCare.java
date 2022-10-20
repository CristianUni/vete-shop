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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VeterinaryCare implements Serializable
{
    //Atributo id atencion veterinaria
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinary_care")
    private Integer id_veterinary_care;

    //Atributo descripcion de la cita
    @Column(nullable = false,length = 500)
    @Length(min = 20, max = 500, message = "la descripcion de la cita debe tener mínimo 20 caracteres y máximo 500")
    @NotBlank(message = "El campo está vacío, ingresar una descripcion a ingresar")
    private String message;

    //Relaciones

    //Lista examenes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinaryCare",cascade = CascadeType.ALL)
    private List<Examination> examinations;

    //id de la cita
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "veterinaryCare",cascade = CascadeType.ALL)
    private Consultation consultations;

    //Atributo id de la mascota
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet")
    private Pet pet;

    //Atributo id del veterinario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinary")
    private Veterinary veterinary;
}
