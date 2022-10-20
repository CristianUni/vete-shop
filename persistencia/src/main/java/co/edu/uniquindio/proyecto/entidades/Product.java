package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Product implements Serializable
{
    //Llave primaria de la entidad

    public Product(String nameProduct, String description, Integer quantityProduct, double price) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantityProduct = quantityProduct;
        this.price = price;
    }

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;

    //Atributo nombre del prodcuto
    @Column(nullable = false,length = 80)
    @Length(min = 4, max = 80, message = "El nombre del producto debe tener mínimo 4 caracteres y máximo 80")
    @NotBlank(message = "El campo está vacío, debe ingresar un nombre del producto")
    private String nameProduct;

    //Atributo Descripcion de producto
    @Column(nullable = false,length = 400)
    @Length(min = 6, max = 400, message = "La descripcio del producto debe tener minimo 6 caracteres")
    @NotBlank(message = "El campo está vacío, debe ingresar una descripcion")
    private String description;

    //Atributo cantidad de producto
    @Column(name = "quantityProduct", nullable = false)
    @Positive(message = "La cantidad de productos debe ser positivo")
    private Integer quantityProduct;

    //Atributo precio del producto en el instante actual
    @Column(nullable = false, precision = 9, scale = 2)
    @Positive(message = "El precio debe ser positivo")
    private double price;

    //Relaciones

    //lista de detalles compra
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL )
    List<PurchaseDetail> purchaseDetails;


    //lista de imagenes
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductImage> productImages;

    //lista de categorias
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductCategory> productCategories;

}