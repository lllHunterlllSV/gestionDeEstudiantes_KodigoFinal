package api.tarea2_kodigoedwinhernandez.Models;

import jakarta.persistence.*;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateria;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL) // Cascada para persistir, actualizar y eliminar
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;


    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
