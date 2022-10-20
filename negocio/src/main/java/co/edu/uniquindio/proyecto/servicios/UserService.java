package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Pet> getPetByIDUser(int id);

}
