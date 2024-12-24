package api.tarea2_kodigoedwinhernandez.Services;

import api.tarea2_kodigoedwinhernandez.Models.Calificacion;
import api.tarea2_kodigoedwinhernandez.Repositorys.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> listarTodas() {
        return calificacionRepository.findAll();
    }

    public Calificacion obtenerPorId(Integer id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
    }

    public Calificacion guardar(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public Calificacion actualizar(Integer id, Calificacion calificacionActualizada) {
        Calificacion calificacionExistente = obtenerPorId(id); // Valida que la calificación exista
        calificacionExistente.setEstudiante(calificacionActualizada.getEstudiante());
        calificacionExistente.setMateria(calificacionActualizada.getMateria());
        calificacionExistente.setNota(calificacionActualizada.getNota());
        calificacionExistente.setFecha(calificacionActualizada.getFecha());
        return calificacionRepository.save(calificacionExistente);
    }

    public void eliminar(Integer id) {
        calificacionRepository.deleteById(id);
    }
}
