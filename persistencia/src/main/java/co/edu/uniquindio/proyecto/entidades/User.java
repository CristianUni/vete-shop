package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//Entidad hijo Usuario
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString(callSuper = true)

public class User extends Person implements Serializable {

    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    //lista de chats
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private List<Chat> chats;

    //lista mascotas
    @OneToMany(fetch =FetchType.LAZY,mappedBy ="user",cascade = CascadeType.ALL )
    private List<Pet>pets;

}
