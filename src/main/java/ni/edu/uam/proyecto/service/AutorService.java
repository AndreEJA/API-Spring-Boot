package ni.edu.uam.proyecto.service;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    // Repositorio para acceder a la base de datos
    private final AutorRepository autorRepository;

    // Inyección del repositorio
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    // Obtiene todos los autores
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    // Busca un autor por ID
    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    // Guarda un nuevo autor
    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    // Actualiza un autor existente
    public Autor actualizar(Long id, Autor autorActualizado) {

        // Busca el autor en la base de datos
        Autor autor = autorRepository.findById(id).orElseThrow();

        // Actualiza los datos
        autor.setNombre(autorActualizado.getNombre());
        autor.setNacionalidad(autorActualizado.getNacionalidad());

        // Guarda los cambios
        return autorRepository.save(autor);
    }

    // Elimina un autor por ID
    public void eliminar(Long id) {
        autorRepository.deleteById(id);
    }
}