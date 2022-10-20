package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Integer>
{
    @Query("select p from Pet p where p.user.id=:id")
    Optional<Pet> getPetByIDUser(int id);


    Optional<User> findByEmail(String email);
}
