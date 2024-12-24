package api.tarea2_kodigoedwinhernandez.Controllers.DTO;

import java.math.BigDecimal;

public class EstudianteNotaDTO {
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private BigDecimal nota;

    // Constructor con los parámetros correctos
    public EstudianteNotaDTO(Integer idEstudiante, String nombre, String apellido, BigDecimal nota) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }



    // Getters y Setters
    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
}
