package ni.edu.uam.proyecto.controller;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.entity.Libro;
import ni.edu.uam.proyecto.repository.AutorRepository;
import ni.edu.uam.proyecto.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define esta clase como controlador REST
@RequestMapping("/api/libros") // Ruta base: /api/libros
public class LibroController {

    private final LibroService libroService;
    private final AutorRepository autorRepository;

    // Inyección de dependencias
    public LibroController(LibroService libroService,
                           AutorRepository autorRepository) {
        this.libroService = libroService;
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Libro> obtenerTodos() {
        // Obtiene todos los libros
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        // Obtiene un libro por ID
        return libroService.obtenerPorId(id).orElseThrow();
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {

        // Obtiene el ID del autor enviado en el JSON
        Long autorId = libro.getAutor().getId();

        // Busca el autor en la base de datos
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow();

        // Asocia el autor al libro
        libro.setAutor(autor);

        // Guarda el libro
        return libroService.guardar(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id,
                            @RequestBody Libro libro) {

        // Actualiza un libro existente
        return libroService.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        // Elimina un libro por ID
        libroService.eliminar(id);
    }
}