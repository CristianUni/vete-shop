package co.edu.uniquindio.proyecto.servicios;
import co.edu.uniquindio.proyecto.entidades.Veterinary;

import java.util.List;

public interface VeterinaryService {

    Veterinary createVeterinary(Veterinary veterinary) throws Exception;
    void deleteVeterinary(String email) throws Exception;

    Veterinary findByEmailAndPassword(String email, String password);

    Veterinary findByEmail(String email);
    List<Veterinary>listVeterinaries();
}
