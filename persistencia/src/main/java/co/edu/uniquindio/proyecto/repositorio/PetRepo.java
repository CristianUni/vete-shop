package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet,Integer> {

    @Query("select p from Pet p where p.status=0 or p.status=1 order by p.status")
    List<Pet> getPetsAdmitted();
}
