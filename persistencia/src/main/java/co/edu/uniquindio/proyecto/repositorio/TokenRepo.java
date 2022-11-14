package co.edu.uniquindio.proyecto.repositorio;


import co.edu.uniquindio.proyecto.entidades.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Optional;

@Transactional
@Repository
public interface TokenRepo extends JpaRepository<Token,String> {

    @Query("select t from Token t where t.email = ?1")
    Optional<Token> findByPK(String email);

    @Modifying(clearAutomatically = true)
    @Query("update Token t set t.expirationDate = ?2 ,t.token = ?3 where t.email = ?1")
    public void setToken(String email, Calendar date, String token);
}
