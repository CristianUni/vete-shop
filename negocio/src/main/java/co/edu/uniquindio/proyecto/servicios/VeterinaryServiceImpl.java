package co.edu.uniquindio.proyecto.servicios;



import co.edu.uniquindio.proyecto.entidades.Veterinary;
import co.edu.uniquindio.proyecto.repositorio.VeterinaryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinaryServiceImpl implements VeterinaryService {

    private final VeterinaryRepo veterinaryRepo;

    public VeterinaryServiceImpl(VeterinaryRepo veterinaryRepo) {
        this.veterinaryRepo = veterinaryRepo;
    }

    @Override
    public Veterinary createVeterinary(Veterinary veterinary) throws Exception {
        Optional<Veterinary> buscado = veterinaryRepo.findByEmail(veterinary.getEmail());

        if (buscado.isPresent()) throw new Exception("El correo " + veterinary.getEmail() + " ya está registrado.");

        return veterinaryRepo.save(veterinary);
    }

    @Override
    public void deleteVeterinary(String email) throws Exception {

        Optional<Veterinary> buscado = veterinaryRepo.findByEmail(email);
        if (buscado.isEmpty()) throw new Exception("El usuario no existe");
        veterinaryRepo.deleteById(buscado.get().getId());

    }

    @Override
    public Veterinary findByEmail(String email) {
        Optional<Veterinary> buscado = veterinaryRepo.findByEmail(email);
        if (buscado.isEmpty()) {

            return null;

        }

        return buscado.get();
    }

    @Override
    public List<Veterinary> listVeterinaries() {
        return veterinaryRepo.findAll();
    }
}
