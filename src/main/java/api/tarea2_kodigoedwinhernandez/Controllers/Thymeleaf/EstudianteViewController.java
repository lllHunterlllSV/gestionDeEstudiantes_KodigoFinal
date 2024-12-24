package api.tarea2_kodigoedwinhernandez.Controllers.Thymeleaf;



import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTO;
import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTOCOC;
import api.tarea2_kodigoedwinhernandez.Controllers.Endpoints.EstudianteApiService;
import api.tarea2_kodigoedwinhernandez.Models.Estudiante;

import api.tarea2_kodigoedwinhernandez.Repositorys.CalificacionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteViewController {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private EstudianteApiService estudianteApiService;


    @GetMapping("/menu")
    public String menu(HttpSession session, Model model) {
        // Obtener el idEstudiante de la sesión
        Integer idEstudiante = (Integer) session.getAttribute("idEstudiante");

        // Verificar si se obtuvo el idEstudiante (si está en sesión)
        if (idEstudiante != null) {
            // Llamar al método de repositorio para obtener las materias y notas del estudiante
            List<EstudianteNotaDTOCOC> estudiantesConNotas = calificacionRepository.obtenerMateriasConNotasYProfesor(idEstudiante);
            model.addAttribute("materias", estudiantesConNotas);
        } else {
            // Si no se encuentra idEstudiante en sesión, redirigir al login
            return "redirect:/login";
        }

        return "estudiantes/menu";
    }


}
