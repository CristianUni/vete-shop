package co.edu.uniquindio.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {

    Collection<T> getAll();

    T save(T item);

    Optional<T> findById(String id);

    void deleteById(String id);
}
