package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
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

    //Relaciones

    //Lista examenes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinaryCare",cascade = CascadeType.ALL)
    private List<Examination> examinations;

    //id de la cita
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "veterinaryCare",cascade = CascadeType.ALL)
    private Consultation consultations;
}
