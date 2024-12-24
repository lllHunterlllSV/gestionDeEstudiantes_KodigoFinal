package api.tarea2_kodigoedwinhernandez.Controllers.Thymeleaf;



import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTO;
import api.tarea2_kodigoedwinhernandez.Controllers.DTO.EstudianteNotaDTOCOC;
import api.tarea2_kodigoedwinhernandez.Models.*;
import api.tarea2_kodigoedwinhernandez.Repositorys.CalificacionRepository;
import api.tarea2_kodigoedwinhernandez.Services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesorViewController {



    @Autowired
    CalificacionRepository calificacionRepository;

    @Autowired
    MateriaService materiaService;

    @Autowired
    EstudianteService estudianteService;


    @Autowired
    ProfesorService profesorService;

    @Autowired
    InscripcionService inscripcionService;

    @Autowired
    CalificacionService calificacionService;

    @GetMapping("/menu")
    public String menu(HttpSession session, Model model) {

        // Obtener los atributos de sesión
        Integer idEstudiante = (Integer) session.getAttribute("idEstudiante");
        Integer idProfesor = (Integer) session.getAttribute("idProfesor");

        // Verificar si el usuario está logeado
        if (idEstudiante == null && idProfesor == null) {
            return "redirect:/login";  // Redirigir al login si no hay sesión
        }

        // Validación del rol
        if (idEstudiante != null) {
            // Si el usuario es un estudiante, realizar la lógica correspondiente
            // Tu lógica para estudiantes
            return "estudiantes/menu";
        } else if (idProfesor != null) {
            // Si el usuario es un profesor, realizar la lógica correspondiente
            // Tu lógica para profesores
            return "profesores/menu";
        }

        materiaService.listarTodas();
        estudianteService.listarTodos();
        model.addAttribute("materias", materiaService.listarTodas());
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "profesores/menu";
    }


    @GetMapping("/inscripcion")
    public String incripcion(Model model) {
        materiaService.listarTodas();
        estudianteService.listarTodos();
        model.addAttribute("materias", materiaService.listarTodas());
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "profesores/inscripcion";
    }


    @PostMapping("/crearInscripcion")
    public String crearIncripcion(Model model, @RequestParam("alumno") int idEstudiante, @RequestParam("materia") int idMateria) {

        Estudiante estudiante = new Estudiante();
        Materia materiaAux = new Materia();

        estudiante = estudianteService.obtenerPorId(idEstudiante);
        materiaAux = materiaService.obtenerPorId(idMateria);


        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setMateria(materiaAux);
        inscripcionService.guardar(inscripcion);

        Calificacion calificacion = new Calificacion();
        calificacion.setEstudiante(estudiante);
        calificacion.setMateria(materiaAux);
        calificacion.setFecha(LocalDate.now());  // Correcto
        calificacion.setNota(new BigDecimal("0.00"));

        calificacionService.guardar(calificacion);

        return "profesores/inscripcion";
    }


    @GetMapping("/crear-materia")
    public String crearMateria(Model model) {
        materiaService.listarTodas();
        profesorService.listarTodos();

        model.addAttribute("materias", materiaService.listarTodas());
        model.addAttribute("profesores", profesorService.listarTodos());
        return "profesores/crearMateria";
    }

    @PostMapping("materias/editar/{id}")
    public String editarMateria(
            @PathVariable int id,
            @RequestParam("nombre") String nombre,
            @RequestParam("idProfesor") int idProfesor
    ) {
        // Buscar la materia existente
        Materia materia = materiaService.obtenerPorId(id);
        if (materia == null) {
            return "redirect:/error";
        }

        // Buscar el profesor por ID
        Profesor profesor = profesorService.obtenerPorId(idProfesor);
        if (profesor == null) {
            return "redirect:/error"; // Manejar error si el profesor no existe
        }

        // Actualizar los datos de la materia
        materia.setNombre(nombre);
        materia.setProfesor(profesor);

        // Guardar los cambios
        materiaService.guardar(materia);

        return "redirect:/profesores/crear-materia";// Redirige a la lista de materias
    }

    @PostMapping("materias/eliminar/{id}")
    public String eliminarMateria(
            @PathVariable int id) {
        materiaService.eliminar(id);

        return "redirect:/profesores/crear-materia";
    }

    @PostMapping("materias/crear")
    public String crearMateria(@RequestParam String nombre, @RequestParam int materiaProfesor) {

        Materia materia = new Materia();
        materia.setNombre(nombre);
        Profesor profesor = profesorService.obtenerPorId(materiaProfesor);

        materia.setProfesor(profesor);
        materiaService.guardar(materia);
        return "redirect:/profesores/crear-materia";
    }


    @GetMapping("/calificaciones")
    public String sistemaNotas(Model model) {
        materiaService.listarTodas();
        model.addAttribute("materias", materiaService.listarTodas());

        return "profesores/notas/home-notas";

    }


    @GetMapping("calificaciones/{idMateria}")
    public String mostrarCalificaciones(@PathVariable Integer idMateria, Model model) {
        List<EstudianteNotaDTO> estudiantesConNotas = calificacionRepository.obtenerEstudiantesConNotas(idMateria);
        model.addAttribute("estudiantes", estudiantesConNotas);
        model.addAttribute("idMateria", idMateria);
        return "profesores/notas/calificaciones";

    }

    @PostMapping("/guardarNotas")
    public String guardarCalificaciones(@RequestParam("idMateria") Integer idMateria,
                                        @RequestParam("idEstudiante") List<Integer> idEstudiantes,
                                        @RequestParam("nota") List<BigDecimal> notas) {

        Materia materia = materiaService.obtenerPorId(idMateria);


        for (int i = 0; i < idEstudiantes.size(); i++) {
            Estudiante estudiante = estudianteService.obtenerPorId(idEstudiantes.get(i));


            // Buscamos la calificación existente o la creamos si no existe
            Calificacion calificacion = calificacionRepository
                    .findByEstudianteAndMateria(estudiante, materia)
                    .orElse(new Calificacion());

            calificacion.setEstudiante(estudiante);
            calificacion.setMateria(materia);
            calificacion.setNota(notas.get(i));  // Asignamos la nueva nota
            calificacion.setFecha(LocalDate.now()); // Establecemos la fecha actual
            calificacionRepository.save(calificacion);  // Guardamos la calificación
        }

        return "redirect:/profesores/calificaciones/" + idMateria;  // Redirige a la URL correcta con el idMateria
    }

}
