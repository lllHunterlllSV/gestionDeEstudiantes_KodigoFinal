package api.tarea2_kodigoedwinhernandez.Controllers.DTO;
import java.math.BigDecimal;

public class EstudianteNotaDTOCOC {

    private Integer idMateria;
    private String nombreMateria;
    private String nombreProfesor;
    private String apellidoProfesor;
    private BigDecimal nota;

    // Constructor para el DTO
    public EstudianteNotaDTOCOC(Integer idMateria, String nombreMateria, String nombreProfesor, String apellidoProfesor, BigDecimal nota) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.nota = nota;
    }

    // Getters y setters
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
}