package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query("select c from Category c where c.description=:name")
    Category findByName(String name);
}
