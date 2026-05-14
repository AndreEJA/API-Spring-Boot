package ni.edu.uam.proyecto.service;

import ni.edu.uam.proyecto.entity.Libro;
import ni.edu.uam.proyecto.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio de Spring
public class LibroService {

    // Repositorio para acceder a la base de datos
    private final LibroRepository libroRepository;

    // Inyección del repositorio
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Obtiene todos los libros
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    // Busca un libro por ID
    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    // Guarda un nuevo libro
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualiza un libro existente
    public Libro actualizar(Long id, Libro libroActualizado) {

        // Busca el libro en la base de datos
        Libro libro = libroRepository.findById(id).orElseThrow();

        // Actualiza los datos del libro
        libro.setTitulo(libroActualizado.getTitulo());
        libro.setPaginas(libroActualizado.getPaginas());

        // Guarda los cambios
        return libroRepository.save(libro);
    }

    // Elimina un libro por ID
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}