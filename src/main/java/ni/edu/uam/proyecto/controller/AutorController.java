package ni.edu.uam.proyecto.controller;

import ni.edu.uam.proyecto.entity.Autor;
import ni.edu.uam.proyecto.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Autor obtenerPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id).orElseThrow();
    }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) {
        return autorService.guardar(autor);
    }

    @PutMapping("/{id}")
    public Autor actualizar(@PathVariable Long id,
                            @RequestBody Autor autor) {
        return autorService.actualizar(id, autor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        autorService.eliminar(id);
    }
}