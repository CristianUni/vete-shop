package co.edu.uniquindio.proyecto.repositorio;


import co.edu.uniquindio.proyecto.entidades.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TokenRepo extends JpaRepository<Token,String> {

}
