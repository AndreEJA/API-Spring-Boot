package ni.edu.uam.proyecto.controller;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define esta clase como controlador REST
@RequestMapping("/api/autores") // Ruta base: /api/autores
public class AutorController {

    private final AutorService autorService;

    // Inyección del servicio
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> obtenerTodos() {
        // Obtiene todos los autores
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Autor obtenerPorId(@PathVariable Long id) {
        // Obtiene un autor por ID
        return autorService.obtenerPorId(id).orElseThrow();
    }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) {
        // Crea un nuevo autor
        return autorService.guardar(autor);
    }

    @PutMapping("/{id}")
    public Autor actualizar(@PathVariable Long id,
                            @RequestBody Autor autor) {
        // Actualiza un autor existente
        return autorService.actualizar(id, autor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        // Elimina un autor por ID
        autorService.eliminar(id);
    }
}