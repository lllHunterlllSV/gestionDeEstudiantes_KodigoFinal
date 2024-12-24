package api.tarea2_kodigoedwinhernandez.Services;

import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import api.tarea2_kodigoedwinhernandez.Repositorys.ProfesorRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> listarTodos() {
        return profesorRepository.findAll();
    }

    public Profesor obtenerPorId(Integer id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }


    public Profesor obtenerPorCorreo(String correo) {
        return profesorRepository.findByCorreo(correo);

    }

    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor actualizar(Integer id, Profesor profesorActualizado) {
        Profesor profesorExistente = obtenerPorId(id); // Valida que el profesor exista
        profesorExistente.setNombre(profesorActualizado.getNombre());
        profesorExistente.setApellido(profesorActualizado.getApellido());
        profesorExistente.setCorreo(profesorActualizado.getCorreo());
        return profesorRepository.save(profesorExistente);
    }

    public void eliminar(Integer id) {
        profesorRepository.deleteById(id);
    }
}
