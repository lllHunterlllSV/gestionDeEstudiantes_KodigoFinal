package api.tarea2_kodigoedwinhernandez.Repositorys;

import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
        public Profesor findByCorreo(String correo);

}
