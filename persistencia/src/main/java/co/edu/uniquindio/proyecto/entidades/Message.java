package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Message implements Serializable
{
    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Integer id;

    //Atributo mensaje que se envia
    @Column(nullable = false,length = 500)
    @Length(min = 1, max = 500, message = "El mensaje debe tener mínimo 1 caracteres y máximo 500")
    @NotBlank(message = "El campo está vacío, ingresar un mensaje a enviar")
    private String message;

    //Atributo fecha del mensaje
    @Column(nullable = false)
    private LocalDate date;

    //Relaciones

    //Atributo chat al que pertenece el mensaje
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chat")
    private Chat chat;
}
