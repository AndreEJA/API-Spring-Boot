package ni.edu.uam.proyecto.controller;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.entity.Libro;
import ni.edu.uam.proyecto.repository.AutorRepository;
import ni.edu.uam.proyecto.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;
    private final AutorRepository autorRepository;

    public LibroController(LibroService libroService,
                           AutorRepository autorRepository) {
        this.libroService = libroService;
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id).orElseThrow();
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {

        Long autorId = libro.getAutor().getId();

        Autor autor = autorRepository.findById(autorId)
                .orElseThrow();

        libro.setAutor(autor);

        return libroService.guardar(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id,
                            @RequestBody Libro libro) {
        return libroService.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
    }
}