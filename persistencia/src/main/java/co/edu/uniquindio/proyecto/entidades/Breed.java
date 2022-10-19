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
public class Breed implements Serializable
{
    //Llave primaria raza
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_breed")
    private Integer id_breed;

    //Atributo descripcion raza
    @Column(nullable = false, length = 45)
    @Length(min = 5, max = 45, message = "la descripcion raza debe tener mínimo 5 caracteres y máximo 10")
    @NotBlank(message = "El campo está vacío, debe ingresar la descripcion")
    private String descriptionBreed;

    //Relaciones

    //Atributo tipo mascota
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_pet")
    private TypePet typePet;
}
