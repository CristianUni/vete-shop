package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProductImage implements Serializable
{
    public ProductImage(String url, Product product) {
        this.url = url;
        this.product = product;
    }

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_image")
    private Integer id;

    //Atributo Link de la imagen
    @Column(nullable = false,length = 150)
    @Length(min = 10, max = 150, message = "El link debe tener minimo 150 caracteres")
    @NotBlank(message = "El campo está vacío, debe ingresar una imagen del producto")
    private String url;

    //Relaciones

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;
}
