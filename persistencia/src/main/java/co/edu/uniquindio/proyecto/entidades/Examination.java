package co.edu.uniquindio.proyecto.entidades;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Examination implements Serializable
{
    //llave primaria examen
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examination")
    private Integer id_examination;

    //Atributo descripcion examen
    @Column(nullable = false,length = 45)
    @Length(min = 5, max = 45, message = "la descripcion raza debe tener mínimo 5 caracteres y máximo 10")
    @NotBlank(message = "El campo está vacío, debe ingresar la descripcion")
    private String descriptionexamination;

    //Atributo especializacion
    @Column(nullable = false,length = 45)
    @Length(min = 5, max = 45, message = "la especializacion  debe tener mínimo 5 caracteres y máximo 10")
    @NotBlank(message = "El campo está vacío, debe ingresar la especializacion")
    private String specialization;

    //Atributo resultados
    @Column(nullable = false,length = 200)
    @Length(min = 5, max = 200, message = "la especializacion  debe tener mínimo 5 caracteres y máximo 200")
    @NotBlank(message = "El campo está vacío, debe ingresar los resultados")
    private String results;

    //Relaciones

    //Atributo id de la atencion veterinaria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinary_care")
    private VeterinaryCare veterinaryCare;

}
