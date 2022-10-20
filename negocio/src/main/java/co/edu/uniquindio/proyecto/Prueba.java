package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.servicios.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositorio.UserRepo;
@Component
public class Prueba {
    @Autowired
    UserServiceImpl userServiceImp;

}
