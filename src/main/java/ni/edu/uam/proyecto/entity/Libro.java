package ni.edu.uam.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data // Genera getters, setters y otros métodos automáticamente
@Entity // Define esta clase como una entidad de la base de datos
@Table(name = "libros") // Nombre de la tabla en PostgreSQL
public class Libro {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementable
    private Long id;

    // Título del libro
    private String titulo;

    // Cantidad de páginas del libro
    private Integer paginas;

    @ManyToOne
    // Relación muchos a uno:
    // muchos libros pueden pertenecer a un autor

    @JoinColumn(name = "autor_id")
    // Columna que conecta con la tabla autores
    @JsonBackReference
    // Evita ciclos infinitos al convertir a JSON
    private Autor autor;
}