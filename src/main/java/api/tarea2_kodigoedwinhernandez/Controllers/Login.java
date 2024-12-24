package api.tarea2_kodigoedwinhernandez.Controllers;


import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import api.tarea2_kodigoedwinhernandez.Services.EstudianteService;
import api.tarea2_kodigoedwinhernandez.Services.ProfesorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {



        @Autowired
        private EstudianteService estudianteService;

        @Autowired
        private ProfesorService profesorService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String correo, @RequestParam("password") String contrasena, HttpSession session) {

        // Verificar si el correo pertenece a un Estudiante
        Estudiante estudiante = estudianteService.obtenerPorCorreo(correo);
        if (estudiante != null && estudiante.getPassword().equals(contrasena)) {
            // Guardar la información del estudiante en la sesión
            session.setAttribute("correo", correo);  // Guardamos el correo
            session.setAttribute("rol", "estudiante");  // Guardamos el rol como "estudiante"
            session.setAttribute("idEstudiante", estudiante.getIdEstudiante());  // Guardamos el ID del estudiante
            return "redirect:/estudiantes/menu";  // Redirigir al estudiante
        }

        // Verificar si el correo pertenece a un Profesor
        Profesor profesor = profesorService.obtenerPorCorreo(correo);
        if (profesor != null && profesor.getPassword().equals(contrasena)) {
            // Guardar la información del profesor en la sesión
            session.setAttribute("correo", correo);  // Guardamos el correo
            session.setAttribute("rol", "profesor");  // Guardamos el rol como "profesor"
            session.setAttribute("idProfesor", profesor.getIdProfesor());  // Guardamos el ID del profesor
            return "redirect:/profesores/menu";  // Redirigir al profesor
        }

        // Si no se encuentra el correo o la contraseña no coincide
        return "redirect:/login?error=true";  // Redirigir a login con mensaje de error
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidar la sesión
        session.invalidate();

        // Redirigir al login después de cerrar sesión
        return "redirect:/login";
    }
}
