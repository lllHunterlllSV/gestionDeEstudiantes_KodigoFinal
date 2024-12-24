package api.tarea2_kodigoedwinhernandez.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL) // Cascada para persistir, actualizar y eliminar
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.ALL) // Cascada para persistir, actualizar y eliminar
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // Constructor vacío (necesario para JPA)
    public Inscripcion() {
    }

    // Constructor con parámetros
    public Inscripcion(Integer id, Estudiante estudiante, Materia materia) {
        this.id = id;
        this.estudiante = estudiante;
        this.materia = materia;
    }
}
