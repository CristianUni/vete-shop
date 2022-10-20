package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    List<Pet> getPetByIDUser(int id);

    User createUser(User user) throws Exception;



    void deleteUser(String email)throws Exception;

    User findByEmail(String email);


    List<User>listUsers();

}
