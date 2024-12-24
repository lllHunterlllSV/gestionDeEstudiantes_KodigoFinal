package api.tarea2_kodigoedwinhernandez.Repositorys;

import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
        public Estudiante findByCorreo(String correo);


}
