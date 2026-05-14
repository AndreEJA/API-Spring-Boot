package ni.edu.uam.proyecto.repository;

import ni.edu.uam.proyecto.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}