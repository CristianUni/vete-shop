package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage,Integer> {
}
