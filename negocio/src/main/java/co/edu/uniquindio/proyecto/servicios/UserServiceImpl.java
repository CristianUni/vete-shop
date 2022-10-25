package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.entidades.User;
import org.springframework.stereotype.Service;
import co.edu.uniquindio.proyecto.repositorio.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Pet> getPetByIDUser(int id) {
        Optional<Pet> listPet = userRepo.getPetByIDUser(id);
        if (listPet.isPresent()) {
            return listPet.stream().collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        Optional<User> buscado = userRepo.findById(user.getId());

        if (buscado.isPresent()) throw new Exception("El codigo " + user.getId() + " ya está registrado.");

        buscado = userRepo.findByEmail(user.getEmail());

        if (buscado.isPresent()) throw new Exception("El correo " + user.getEmail() + " ya está registrado.");

        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String email) throws Exception {

        Optional<User> buscado = userRepo.findByEmail(email);
        if (buscado.isEmpty()) throw new Exception("El usuario no existe");
        userRepo.deleteById(buscado.get().getId());


    }

    @Override
    public User findByEmail(String email) {

        Optional<User> buscado = userRepo.findByEmail(email);
        if (buscado.isEmpty()) {

            return null;

        }
        ;
        return buscado.get();
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
