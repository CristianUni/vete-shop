package co.edu.uniquindio.proyecto.entidades;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Purchase implements Serializable
{
    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Integer id;

    //Atributo que sirve para guardar la hora y fecha de cuando se hace una compra
    @Column(name = "date_purchase",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime buyDate;

    //Atributo cedula de la persona
    @Column(nullable = false,length = 20)
    @NotBlank(message = "El campo está vacío, debe ingresar un medio de pago valido")
    private String paymentMethod;

    //Relaciones

    //id del usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    //lista de detalles compra
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase",cascade = CascadeType.ALL)
    private List<PurchaseDetail> purchaseDetails;
}
