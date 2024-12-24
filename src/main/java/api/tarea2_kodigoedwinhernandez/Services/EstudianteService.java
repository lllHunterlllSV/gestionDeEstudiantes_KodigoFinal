package api.tarea2_kodigoedwinhernandez.Services;

import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Repositorys.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerPorId(Integer id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public Estudiante obtenerPorCorreo(String correo) {

        return estudianteRepository.findByCorreo(correo);

    }

    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizar(Integer id, Estudiante estudianteActualizado) {
        Estudiante estudianteExistente = obtenerPorId(id); // Valida que el estudiante exista
        estudianteExistente.setNombre(estudianteActualizado.getNombre());
        estudianteExistente.setApellido(estudianteActualizado.getApellido());
        estudianteExistente.setCorreo(estudianteActualizado.getCorreo());
        estudianteExistente.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());
        return estudianteRepository.save(estudianteExistente);
    }

    public void eliminar(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
