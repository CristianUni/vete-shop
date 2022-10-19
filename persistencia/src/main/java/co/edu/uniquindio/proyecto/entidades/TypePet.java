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
public class TypePet implements Serializable
{
    //llave primaria de tipomascota
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_pet")
    private Integer id;

    //Atributo descripcion
    @Column(nullable = false,length = 100)
    @Length(min = 2, max = 100, message = "la descripcion debe tener mínimo 2 caracteres y máximo 80")
    @NotBlank(message = "El campo está vacío, debe ingresar una descripcion")
    private String descripcion;

    //Relaciones

    //lista mascotas
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "typePet",cascade = CascadeType.ALL )
    private List<Pet> pets;

    //lista razas
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "typePet",cascade = CascadeType.ALL)
    private List<Breed> breeds;
}
