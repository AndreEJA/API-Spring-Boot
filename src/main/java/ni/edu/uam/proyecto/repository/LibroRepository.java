package ni.edu.uam.proyecto.repository;

import ni.edu.uam.proyecto.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}