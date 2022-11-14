package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;

import java.util.List;

public interface UserService
{
    List<Pet> getPetByIDUser(int id);

    User getByEmailAndPassword(String name, String password) throws Exception;

    User createUser(User user) throws Exception;

    void deleteUser(String email)throws Exception;

    User findByEmail(String email);

    List<User>listUsers();

}
