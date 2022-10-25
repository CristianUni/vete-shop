package co.edu.uniquindio.proyecto.repositorio;



import co.edu.uniquindio.proyecto.entidades.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinaryRepo extends JpaRepository<Veterinary,Integer> {




    @Query("select v from Veterinary v where v.email=:email")
    Optional<Veterinary> findByEmail(String email);
}
