package api.tarea2_kodigoedwinhernandez.Controllers.Thymeleaf;

import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import api.tarea2_kodigoedwinhernandez.Repositorys.EstudianteRepository;
import api.tarea2_kodigoedwinhernandez.Repositorys.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CreadorController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    // Vista para crear Estudiante y Profesor
    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("profesor", new Profesor());
        return "profesores/crear";
    }

    // Procesar el formulario para crear Estudiante
    @PostMapping("/crearEstudiante")
    public String crearEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/crearUsuario";
    }

    // Procesar el formulario para crear Profesor
    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor) {
        profesorRepository.save(profesor);
        return "redirect:/crearUsuario";
    }
}
