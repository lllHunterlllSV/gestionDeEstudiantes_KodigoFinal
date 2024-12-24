package api.tarea2_kodigoedwinhernandez.Services;

import api.tarea2_kodigoedwinhernandez.Models.Inscripcion;
import api.tarea2_kodigoedwinhernandez.Repositorys.InscripcionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    // Listar todos las inscripciones
    public List<Inscripcion> listarTodos() {
        return inscripcionRepository.findAll();
    }


    public Inscripcion guardar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }


    public Optional<Inscripcion> obtenerPorId(Integer id) {
        return inscripcionRepository.findById(id);
    }


    public void eliminar(Integer id) {
        try {
            inscripcionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // Aquí puedes manejar el error si el ID no existe
            System.out.println("No se encontró inscripción con ID: " + id);
        }
    }




}


