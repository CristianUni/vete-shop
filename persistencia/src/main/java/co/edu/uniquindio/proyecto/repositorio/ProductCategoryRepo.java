package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
}
