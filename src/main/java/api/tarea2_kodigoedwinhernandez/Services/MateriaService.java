package api.tarea2_kodigoedwinhernandez.Services;

import api.tarea2_kodigoedwinhernandez.Models.Materia;
import api.tarea2_kodigoedwinhernandez.Repositorys.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> listarTodas() {
        return materiaRepository.findAll();
    }

    public Materia obtenerPorId(Integer id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
    }

    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia actualizar(Integer id, Materia materiaActualizada) {
        Materia materiaExistente = obtenerPorId(id); // Valida que la materia exista
        materiaExistente.setNombre(materiaActualizada.getNombre());
        materiaExistente.setProfesor(materiaActualizada.getProfesor());
        return materiaRepository.save(materiaExistente);
    }

    public void eliminar(Integer id) {
        materiaRepository.deleteById(id);
    }
}
