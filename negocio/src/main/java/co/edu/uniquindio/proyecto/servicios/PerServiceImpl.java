package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Pet;
import co.edu.uniquindio.proyecto.repositorio.PetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerServiceImpl implements PetService{

    private final PetRepo petRepo;

    public PerServiceImpl(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public List<Pet> getPetsAdmitted() {
        List<Pet> pets = petRepo.getPetsAdmitted();
        return pets;
    }
}
