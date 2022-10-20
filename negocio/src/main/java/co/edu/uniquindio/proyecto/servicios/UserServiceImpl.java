package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;
import org.springframework.stereotype.Service;
import repositorio.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService
{
private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<Pet> getPetByIDUser(int id)
    {
        Optional<Pet> listPet = userRepo.getPetByIDUser(id);
        if(listPet.isPresent())
        {

            return listPet.stream().collect(Collectors.toList());
        }
        else
        {

        }
        return null;
    }
}
