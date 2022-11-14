package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Admin;

public interface AdminService {

    Admin findByEmailAndPassword(String email,String password);
}
