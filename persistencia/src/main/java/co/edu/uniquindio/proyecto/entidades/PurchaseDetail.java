package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class PurchaseDetail implements Serializable {

    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_detail")
    private Integer id;

    @Column(name = "units", nullable = false)
    private Integer units;

    //Atributo precio del producto cuando fue comprado
    @Column(nullable = false, precision = 9, scale = 2)
    @Positive(message = "El precio debe ser positivo")
    private double price;

    //relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase",nullable = true)
    private Purchase purchase;
}
