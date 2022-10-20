package repositorio;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("select p from User u join Pet p on u.id=p.user.id where u.id=:id")
    Optional<Pet> getPetByIDUser(int id);
}
