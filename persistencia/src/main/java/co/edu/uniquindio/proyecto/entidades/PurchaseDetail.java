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
public class PurchaseDetail implements Serializable
{
    //Llave primaria de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_detail")
    private Integer id;

    //Atributo cantidad de productos comprados
    @Column(name = "units", nullable = false)
    private Integer units;

    //Atributo precio del producto cuando fue comprado
    @Column(nullable = false, precision = 9, scale = 2)
    @Positive(message = "El precio debe ser positivo")
    private double price;

    //Relaciones

    //id de la compra
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase")
    private Purchase purchase;

    //id del producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;
}
