package api.tarea2_kodigoedwinhernandez.Repositorys;

import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTO;
import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTOCOC;
import api.tarea2_kodigoedwinhernandez.Models.Calificacion;
import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;

import java.util.List;
import java.util.Optional;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

    Optional<Calificacion> findByEstudianteAndMateria(Estudiante estudiante, Materia materia);


    @Query("SELECT new api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTO(e.idEstudiante, e.nombre, e.apellido, c.nota) " +
            "FROM Inscripcion i " +
            "JOIN i.estudiante e " +
            "LEFT JOIN Calificacion c ON c.estudiante.idEstudiante = e.idEstudiante AND c.materia.idMateria = i.materia.idMateria " +
            "WHERE i.materia.idMateria = :idMateria")
    List<EstudianteNotaDTO> obtenerEstudiantesConNotas(@Param("idMateria") Integer idMateria);



    @Query("SELECT new api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTOCOC(m.idMateria, m.nombre, p.nombre, p.apellido, c.nota) " +
            "FROM Inscripcion i " +
            "JOIN i.materia m " +
            "JOIN m.profesor p " +
            "LEFT JOIN Calificacion c ON c.materia.idMateria = m.idMateria AND c.estudiante.idEstudiante = i.estudiante.idEstudiante " +
            "WHERE i.estudiante.idEstudiante = :idEstudiante")
    List<EstudianteNotaDTOCOC> obtenerMateriasConNotasYProfesor(@Param("idEstudiante") Integer idEstudiante);


}
