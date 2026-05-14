package ni.edu.uam.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data // Genera automáticamente getters, setters y otros métodos
@Entity // Indica que esta clase es una entidad de la base de datos
@Table(name = "autores") // Nombre de la tabla en PostgreSQL
public class Autor {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementable
    private Long id;

    // Nombre del autor
    private String nombre;

    // Nacionalidad del autor
    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    // Relación uno a muchos:
    // un autor puede tener varios libros

    @JsonManagedReference
    // Evita ciclos infinitos al convertir a JSON
    private List<Libro> libros;
}