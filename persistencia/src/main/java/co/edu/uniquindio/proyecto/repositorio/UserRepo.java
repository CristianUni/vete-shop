package co.edu.uniquindio.proyecto.repositorio;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Integer>
{
    @Query("select p from Pet p where p.user.id=:id")
    Optional<Pet> getPetByIDUser(int id);

    @Query("select u from User u where u.email=:email")
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User getByEmailAndPassword(String email,String password);

}
