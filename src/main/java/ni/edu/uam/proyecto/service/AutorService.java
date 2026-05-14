package ni.edu.uam.proyecto.service;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor actualizar(Long id, Autor autorActualizado) {
        Autor autor = autorRepository.findById(id).orElseThrow();

        autor.setNombre(autorActualizado.getNombre());
        autor.setNacionalidad(autorActualizado.getNacionalidad());

        return autorRepository.save(autor);
    }

    public void eliminar(Long id) {
        autorRepository.deleteById(id);
    }
}