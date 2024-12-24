package api.tarea2_kodigoedwinhernandez;

import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Models.Profesor;

import api.tarea2_kodigoedwinhernandez.Repositorys.EstudianteRepository;
import api.tarea2_kodigoedwinhernandez.Repositorys.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Tarea2KodigoEdwinHernandezApplication {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tarea2KodigoEdwinHernandezApplication.class, args);
    }

    // Crear el CommandLineRunner para inicializar los usuarios por defecto
    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Crear un Estudiante por defecto si no existe
            if (estudianteRepository.findByCorreo("usuario@default.com") == null) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre("Usuario");
                estudiante.setApellido("Predeterminado");
                estudiante.setCorreo("usuario@default.com");
                estudiante.setPassword("defaultPassword");  // No uses contraseñas en texto plano en producción
                estudiante.setFechaNacimiento(LocalDate.of(2000, 1, 1));
                estudianteRepository.save(estudiante);
            }

            // Crear un Profesor por defecto si no existe
            if (profesorRepository.findByCorreo("profesor@default.com") == null) {
                Profesor profesor = new Profesor();
                profesor.setNombre("Profesor");
                profesor.setApellido("Predeterminado");
                profesor.setCorreo("profesor@default.com");
                profesor.setPassword("defaultPassword");  // No uses contraseñas en texto plano en producción
                profesorRepository.save(profesor);
            }
        };
    }
}
