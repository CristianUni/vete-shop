package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Admin;
import co.edu.uniquindio.proyecto.repositorio.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{

    private final AdminRepo adminRepo;

    public AdminServiceImp(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) {
        Optional<Admin> buscado = adminRepo.findByEmailAndPassword(email, password);
        if(buscado.isEmpty())
        {
            return null;
        }
        return buscado.get();
    }
}
