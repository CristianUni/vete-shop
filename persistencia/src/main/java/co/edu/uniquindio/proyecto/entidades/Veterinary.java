package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
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

    //Relaciones

    //lista de chats
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinary",cascade = CascadeType.ALL)
    private List<Chat> chats;

    //lista consultas
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "veterinary",cascade = CascadeType.ALL )
    private List<Consultation> consultations;

    //lista atenciones
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "veterinary",cascade = CascadeType.ALL )
    private List<VeterinaryCare> veterinaryCares;
}
